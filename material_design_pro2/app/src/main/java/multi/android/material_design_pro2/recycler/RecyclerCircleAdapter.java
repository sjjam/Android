package multi.android.material_design_pro2.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import multi.android.material_design_pro2.R;

public class RecyclerCircleAdapter extends RecyclerView.Adapter<RecyclerCircleAdapter.ViewHolder>{
    Context context;
    int row_res_id; //row를 구성하는 layout
    List<CircleItem> data;

    public RecyclerCircleAdapter(Context context, int row_res_id, List<CircleItem> data) {
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
        CircleImageView row_img_view = holder.imgView;
        row_img_view.setImageResource(data.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgView;
        public ViewHolder(@NonNull View imgview) {
            super(imgview);
            imgView = itemView.findViewById(R.id.imgview);
        }
    }
}
