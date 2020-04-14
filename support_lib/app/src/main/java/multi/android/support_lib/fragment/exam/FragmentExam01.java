package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;

public class FragmentExam01 extends AppCompatActivity {
    ViewFragment1 ViewFragment1;
    ViewFragment2 ViewFragment2;
    ViewFragment3 ViewFragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

        ViewFragment1 = new ViewFragment1();
        ViewFragment2 = new ViewFragment2();
        ViewFragment3 = new ViewFragment3();

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("view1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("view2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("view3");
            }
        });*/
    }

    public void btn_click(View view){
        setFragment(view.getTag().toString());
    }

    public void setFragment(String view){
        Log.d("fragment",view);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //프레그먼트의 변화를 관리하는 객체
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (view){
            case "0":
                transaction.replace(R.id.container,ViewFragment1);
                break;
            case "1":
                transaction.replace(R.id.container,ViewFragment2);
                break;
            case "2":
                transaction.replace(R.id.container,ViewFragment3);
        }
        transaction.commit();
    }
}
