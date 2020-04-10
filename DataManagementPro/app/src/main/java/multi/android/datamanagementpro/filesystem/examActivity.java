package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class examActivity extends AppCompatActivity {
    EditText writedata;
    Button open;
    Button save;
    boolean permission_state;
    TextView textread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
            && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            permission_state = true;
            printToast("권한이 설정되었습니다.");
        }else {
            permission_state = false;
            printToast("권한을 설정해야 합니다.");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},1000);
        }

        writedata = findViewById(R.id.editwrite);
        open = findViewById(R.id.open);
        save = findViewById(R.id.save);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000 && grantResults.length>0){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
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

    public void write(){
        if (permission_state) {
            printToast("권한설정완료");
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)) {
                File exteranl = Environment.getExternalStorageDirectory();
                String dirPath = exteranl.getAbsolutePath();
                File dir = new File(dirPath + "/mynote");
                if (!dir.exists()) {
                    dir.mkdir();
                }

                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir + "/20200410_memo.txt");
                    fw.write(writedata.getText() + "");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fw != null) {
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {

            }
        }else {
            printToast("권한을 설정해야 이 기능을 쓸 수 있습니다.");
        }
    }

    public void read() {
        if (permission_state) {
            printToast("권한설정완료");
            try {
                File exteranl = Environment.getExternalStorageDirectory();
                String dirPath = exteranl.getAbsolutePath();
                FileReader fr = new FileReader(dirPath + "/mynote/20200410_memo.txt");
                BufferedReader br = new BufferedReader(fr);
                try {
                    //int num = Integer.parseInt(br.readLine());
                    //br.close();
                    String line = "";
                    line = br.readLine();
                    //for (int i=1; i<num; i++){
                        textread.append(line);
                    //}
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            printToast("권한을 설정해야 이 기능을 쓸 수 있습니다.");
        }
    }
}
