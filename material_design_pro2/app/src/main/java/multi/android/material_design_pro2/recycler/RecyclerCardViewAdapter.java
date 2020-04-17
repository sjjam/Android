package multi.android.material_design_pro2.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import multi.android.material_design_pro2.R;

public class RecyclerCardViewAdapter extends RecyclerView.Adapter<RecyclerCardViewAdapter.ViewHolder>{
    Context context;
    int row_res_id; //row를 구성하는 layout
    List<CardViewItem> data;

    public RecyclerCardViewAdapter(Context context, int row_res_id, List<CardViewItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView row_img_view = holder.img;
        TextView row_txt_view = holder.txt;
        row_img_view.setImageResource(data.get(position).getImg());
        row_txt_view.setText(data.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public ViewHolder(@NonNull View imgview) {
            super(imgview);
            img = imgview.findViewById(R.id.imgcard);
            txt = imgview.findViewById(R.id.textcard);
        }
    }
}
