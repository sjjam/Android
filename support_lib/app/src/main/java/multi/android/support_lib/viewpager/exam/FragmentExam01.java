package multi.android.support_lib.viewpager.exam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;

public class FragmentExam01 extends AppCompatActivity {
    ViewFragment1 ViewFragment1;
    //ViewFragment2 ViewFragment2;
    ListTestFragment ViewFragment2;
    ViewFragment3 ViewFragment3;
    MapFragment ViewFragment4;
    ViewPager fragment_viewPager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);

        ViewFragment1 = new ViewFragment1();
        ViewFragment2 = new ListTestFragment();
        ViewFragment3 = new ViewFragment3();
        ViewFragment4 = new MapFragment();

        fragmentArrayList.add(ViewFragment1);
        fragmentArrayList.add(ViewFragment2);
        fragmentArrayList.add(ViewFragment3);
        fragmentArrayList.add(ViewFragment4);

        FragAdapter adpter = new FragAdapter(getSupportFragmentManager(),fragmentArrayList.size());

        fragment_viewPager.setAdapter(adpter);
        fragment_viewPager.addOnPageChangeListener(new PageListener());
    }

    public void btn_click(View view){
        fragment_viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }

    //Fragment 많을때 FragmentStatePagerAdapter
    class FragAdapter extends FragmentStatePagerAdapter {

        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }
    }

    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을때
            Toast.makeText(FragmentExam01.this,"페이지가 전환",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
