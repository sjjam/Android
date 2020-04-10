package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class ExternalFileMgr extends AppCompatActivity {
    TextView view;
    String path;
    boolean permission_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file_mgr);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            permission_state = true;
            printToast("권한이 설정되었습니다.");
        }else {
            permission_state = false;
            printToast("권한을 설정해야 합니다.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1000);
        }
    }

    public void printToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permission_state = true;
                printToast("권한 설정 마무리 완료");
            } else {
                printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다.");
            }
        }
    }
    public void saveExternalFileSystem(View v){
        if (permission_state) {
            printToast("권한설정완료");
            //외부저장소를 사용할 수 잇는지 state를 추출
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)){ //사용가능한 상태
                printToast("사용가능");
                File exteranl = Environment.getExternalStorageDirectory();
                //외부저장소/임의의디렉토리를 생성 - 앱을 삭제해도 데이터는 남아있다.
                //String dirPath = exteranl.getAbsolutePath()+"/myApp";
                //외부저장소/android/data/앱의 패키지명으로 디렉토리 생성
                //=> 앱을 삭제하면 데이터가 같이 삭제된다.
                String dirPath = exteranl.getAbsolutePath();
                String pkg = getPackageName();
                File dir = new File(dirPath+"/android/data/"+pkg);
                //디렉토리 없으면생성
                //File dir = new File(dirPath);
                if (!dir.exists()){
                    dir.mkdir();
                }

                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"/test1.txt");
                    fw.write("외부저장소 테스트중");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fw!=null){
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }else {
                printToast("사용불가능");
            }
        }else {
            printToast("권한을 설정해야 이 기능을 쓸 수 있습니다.");
        }
    }
}
