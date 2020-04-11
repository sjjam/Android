package multi.android.datamanagementpro.sqlite.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import multi.android.datamanagementpro.R;
import multi.android.datamanagementpro.sqlite.DBHelper;

public class DBHandler {
    SQLiteDatabase db;
    ListView listview;
    ExamDBHelper dbHelper;
    Context context;
    public DBHandler(Context context){
        this.context = context;
        dbHelper = new ExamDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insert(String edtName, String edtPrice, String edtSu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",edtName);
        contentValues.put("price",edtPrice);
        contentValues.put("su",edtSu);
        contentValues.put("totPrice", Integer.parseInt(edtPrice)*Integer.parseInt(edtSu));

        db.insert("product",null, contentValues);
    };
    public ArrayList selectAll1(){
        String sql = "select * from product";

        Cursor cursor = db.query("product",null,null,null,
                null,null,null);

        ArrayList<String> list = new ArrayList<>();
        while (cursor.moveToNext()){
            int _id = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            int su = cursor.getInt(3);
            int totPrice = cursor.getInt(4);

            list.add(_id+" "+name+" "+price+" "+su+" "+totPrice);
        }
        return list;

    };
    public ArrayList selectAll2(){
        String sql = "select name, price from product";

        Cursor cursor = db.query("product",null,null,null,
                null,null,null);
        ArrayList<String> list = new ArrayList<>();
        while (cursor.moveToNext()){
            int _id = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            int su = cursor.getInt(3);
            int totPrice = cursor.getInt(4);

            list.add(name+"\n"+price);
        }
        return list;
    };
    public ArrayList search(String[] edtName){
        String sql = "select * from product";

        Cursor cursor = db.query("product",null,"name = ?",edtName,
                null,null,null);

        ArrayList<String> list = new ArrayList<>();
        while (cursor.moveToNext()){
            int _id = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            int su = cursor.getInt(3);
            int totPrice = cursor.getInt(4);

            list.add(name+"\n"+price);
        }
        return list;
    };
}
