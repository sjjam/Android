package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncTaskExam extends AppCompatActivity {
    Button btn1;
    Button btn2;
    TextView textView;
    ProgressBar progressBar;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        img = findViewById(R.id.imageView);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

        btn2.setEnabled(false);
        final Async async = new Async();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                async.execute();
            }
        });

    }

    class Async extends AsyncTask<Void, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            btn1.setEnabled(false);
            btn2.setEnabled(true);
            progressBar.setMax(50);
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            int sum = 0;
            for (int i=1; i<=50; i++){
                SystemClock.sleep(100);
                sum += i;
                publishProgress(i);
            }
            return sum;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.incrementProgressBy(1);
            if (values[0]%2 == 1){
                img.setImageResource(R.drawable.d1);
                textView.setText(values[0]+"");
            }else {
                img.setImageResource(R.drawable.d2);
                textView.setText(values[0]+"");
            }
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            textView.setText("Result: "+integer+"");
        }
    }
}
