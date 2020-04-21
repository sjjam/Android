package multi.android.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerExam extends AppCompatActivity {
    TextView txt;
    Button btn;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        txt = findViewById(R.id.txt);

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what==3){
                    int num = msg.arg1;
                    txt.setText(num+"");
                }
            }
        };
    }

    public void handler(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =1; i<=10; i++){
                    Message msg = new Message();
                    msg.what = 3;
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                    SystemClock.sleep(100);
                }
            }
        }).start();
    }
}
