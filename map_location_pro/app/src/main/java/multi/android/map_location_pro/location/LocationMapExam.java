package multi.android.map_location_pro.location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import multi.android.map_location_pro.R;
//현재 위치정보를 가져와서 맵에 연결해서 출력 - avd, device
public class LocationMapExam extends AppCompatActivity implements LocationListener, OnMapReadyCallback {
    LocationManager locationManager;
    boolean permission_state;
    GoogleMap map;
    List<String> provider_list; //전체 위치 제공자 목록
    List<String> enableProvider_list; //사용 가능한 위치 제공자 목록
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_map_exam);
        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)manager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED |
                ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED){
            printToast("권한이 없습니다.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION},1000);
        }else {
            permission_state = true;
            printToast("권한을 설정해야 합니다.");
            getLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000 && grantResults.length>0){ //권한의 성공 설정에 대한 결과가 있다는 의미
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED & grantResults[1]==PackageManager.PERMISSION_GRANTED){
                permission_state = true;
                printToast("권한 설정 마무리 완료");
            }else {
                printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다.");
            }
        }
    }

    public void printToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void getLocation(){
        for (String provider:enableProvider_list){
            Location location = null;
            try {
                location = locationManager.getLastKnownLocation(provider);
                if (location!=null){
                    //이벤트 연결
                    locationManager.requestLocationUpdates(provider,3000,1,this);
                }
                Log.d("msg","=========성공=========");
            }catch (SecurityException e){
                Log.d("msg","=============="+e.getMessage()+"====");
            }

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        double latitude = 0;
        double longitude = 0;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //위치정보를 제공하는 제공자로부터 위치정보를 담고 있는 Location객체를 가져오기
        try {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null){
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                Log.d("msg",latitude+","+longitude+"******");
            }else {
                Log.d("msg","location객체 실패");
            }
        }catch (SecurityException e){
            Log.d("msg", e.getMessage());
        }

        if(map!=null){
            //위도,경도지정
            LatLng latLng= new LatLng(latitude,longitude);
            //지도 확대축소 버튼을 추가
            map.getUiSettings().setZoomControlsEnabled(true);
            //현재 나의 위치를 포인트로 표시 - 위치기반 서비스에 대한 퍼미션 체크가 완료되어야 표시
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

        }
    }
}
