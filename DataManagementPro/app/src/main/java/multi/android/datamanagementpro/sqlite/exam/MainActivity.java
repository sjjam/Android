package multi.android.datamanagementpro.sqlite.exam;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import multi.android.datamanagementpro.R;


public class MainActivity extends
		AppCompatActivity implements AdapterView.OnItemClickListener,OnClickListener {
	DBHandler handler;
	EditText edtName;
	EditText edtSu;
	EditText edtPrice;
	ListView listview;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//handler = DBHandler.open(this);
		handler = new DBHandler(this);

		findViewById(R.id.btnIns).setOnClickListener(this);
		findViewById(R.id.btnResult).setOnClickListener(this);
		findViewById(R.id.btnResult2).setOnClickListener(this);
		findViewById(R.id.btnSearch).setOnClickListener(this);
		listview = findViewById(R.id.list);
		listview.setOnItemClickListener(this);

		edtName = (EditText)findViewById(R.id.edtName);
		edtSu = (EditText)findViewById(R.id.edtSu);
		edtPrice = (EditText)findViewById(R.id.edtPrice);

	}


	@Override
	public void onClick(View v) {
		if (v.getId()==R.id.btnIns){
 			handler.insert(edtName.getText().toString(),edtPrice.getText().toString(),
					edtSu.getText().toString());
		}else if (v.getId()==R.id.btnResult){
			ArrayList<String> list = new ArrayList<>();
			list = handler.selectAll1();
			ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
			listview.setAdapter(adapter);
		}else if (v.getId()==R.id.btnResult2){
			ArrayList<String> list = new ArrayList<>();
			list = handler.selectAll2();
			ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
			listview.setAdapter(adapter);
		}else if (v.getId()==R.id.btnSearch){
			ArrayList<String> list = new ArrayList<>();
			String[] item = {edtName.getText().toString()};
			list = handler.search(item);
			ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
			listview.setAdapter(adapter);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		ArrayList<String> list = new ArrayList<>();
		list = handler.selectAll1();
		Intent intent = new Intent(MainActivity.this,ReadActivity.class);
		intent.putExtra("product",list.get(position));
		startActivity(intent);
	}
}



















