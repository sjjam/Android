package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ViewHolder {
    ImageView myImg;
    TextView nameView;
    TextView dateView;
    TextView commentView;
    CheckBox checkView;

    public ViewHolder(View parentView) {
        this.myImg = parentView.findViewById(R.id.img);
        this.nameView = parentView.findViewById(R.id.txtcust1);
        this.dateView = parentView.findViewById(R.id.txtcust2);
        this.commentView = parentView.findViewById(R.id.txtcust3);
        this.checkView = parentView.findViewById(R.id.check);
    }
}
