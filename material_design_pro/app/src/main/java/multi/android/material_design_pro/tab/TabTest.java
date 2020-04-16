package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.exam.ListTestFragment;
import multi.android.material_design_pro.exam.ViewFragment1;
import multi.android.material_design_pro.exam.ViewFragment3;

public class TabTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ViewFragment1 ViewFragment1;
        final ListTestFragment ViewFragment2;
        final ViewFragment3 ViewFragment3;
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        TabLayout tabLayout;
        BottomNavigationView bottomNavigationView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);

        ViewFragment1 = new ViewFragment1();
        ViewFragment2 = new ListTestFragment();
        ViewFragment3 = new ViewFragment3();

        tabLayout = findViewById(R.id.mytab);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //탭 추가
        tabLayout.addTab(tabLayout.newTab().setText("설정"));

        //처음 실행할때 보여줄 프레그먼트 지정
        getSupportFragmentManager().beginTransaction().replace(R.id.content_container,ViewFragment1).commit();

        //탭에 이벤트 연결하기
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //탭이 선택될때 호출되는 메소드
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("tab",position+"");
                Fragment fragment = null;
                if(position == 0){
                    fragment = ViewFragment1;
                }else if(position == 1){
                    fragment = ViewFragment2;
                }else{
                    fragment = ViewFragment3;
                }
                //탭을 선택할 때 지정된 프레그먼트 객체가 show되도록 연결
                getSupportFragmentManager().beginTransaction().replace(R.id.content_container,fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //BottomNavigationView 이벤트 연결
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.bottom_item2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_container,ViewFragment2).commit();
                }
                return false;
            }
        });
    }
}
