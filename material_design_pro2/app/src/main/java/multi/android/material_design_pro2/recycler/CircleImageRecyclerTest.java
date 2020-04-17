package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView imglist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        imglist = findViewById(R.id.imglist);
        List<CircleItem> imgitemlist = new ArrayList<CircleItem>();
        List<Integer> img = new ArrayList<>();
        img.add(R.drawable.lee);
        img.add(R.drawable.gong);
        img.add(R.drawable.jang);
        img.add(R.drawable.jung);
        img.add(R.drawable.so);
        for (int i=0; i<img.size(); i++){
            CircleItem imgitem = new CircleItem(img.get(i));
            imgitemlist.add(imgitem);
        }
        RecyclerCircleAdapter adapter = new RecyclerCircleAdapter(this,R.layout.circle_item,imgitemlist);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        /*GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);*/
        imglist.setHasFixedSize(true);
        imglist.setLayoutManager(manager);

        imglist.setAdapter(adapter);
    }
}
