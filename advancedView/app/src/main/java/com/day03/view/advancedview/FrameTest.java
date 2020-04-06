package com.day03.view.advancedview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FrameTest extends AppCompatActivity{
    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;
    int index;
    EditText txt1;
    EditText txt2;
    EditText txt3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout_test);

        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);

        txt1 = findViewById(R.id.editText);
        txt2 = findViewById(R.id.editText2);
        txt3 = findViewById(R.id.editText3);

        tv = findViewById(R.id.textView2);
    }

    public void ck(View v) {
        if(v.getId()==R.id.button){
            linear1.setVisibility(View.VISIBLE);
            linear2.setVisibility(View.INVISIBLE);
            linear3.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.button2){
            linear1.setVisibility(View.INVISIBLE);
            linear2.setVisibility(View.VISIBLE);
            linear3.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.button3){
            linear1.setVisibility(View.INVISIBLE);
            linear2.setVisibility(View.INVISIBLE);
            linear3.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.button4){
            tv.setText(txt1.getText()+"\n" + txt2.getText()+"\n" + txt3.getText()+"\n");
        }
    }
}
