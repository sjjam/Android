package multi.android.datamanagementpro.sqlite.exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ExamDBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;

    public ExamDBHelper(Context context) {
        //파일형태로 데이터가 저장된다. - 이 자체가 데이터베이스를 오픈하고 연결
        super(context, "product.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("dbtest","데이터베이스가 생성되엇습니다.");
        String sql = "create table product("

                + "_id integer primary key autoincrement,"

                + "name text not null, "

                + "price integer not null, "

                + "su integer not null, "

                + "totPrice integer not null)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
