package multi.android.material_design_pro2.recycler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CardViewRecyclerTest extends AppCompatActivity {
    RecyclerView imglist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        imglist = findViewById(R.id.imglist);
        List<CardViewItem> imgitemlist = new ArrayList<CardViewItem>();
        List<Integer> img = new ArrayList<>();
        List<String> txt = new ArrayList<>();
        img.add(R.drawable.lee);
        img.add(R.drawable.gong);
        img.add(R.drawable.jang);
        img.add(R.drawable.jung);
        img.add(R.drawable.so);
        txt.add("이");
        txt.add("공");
        txt.add("장");
        txt.add("정");
        txt.add("소");
        for (int i=0; i<img.size(); i++){
            CardViewItem imgitem = new CardViewItem(img.get(i),txt.get(i));
            imgitemlist.add(imgitem);
        }
        RecyclerCardViewAdapter adapter = new RecyclerCardViewAdapter(this,R.layout.card_view_exam,imgitemlist);
        /*LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);*/
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),1);
        imglist.setHasFixedSize(true);
        imglist.setLayoutManager(manager);

        imglist.setAdapter(adapter);
    }
}
