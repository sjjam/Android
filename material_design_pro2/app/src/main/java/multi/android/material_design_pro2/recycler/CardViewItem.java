package multi.android.material_design_pro2.recycler;

import android.widget.ImageView;

public class CardViewItem {
    int img;
    String data;

    public CardViewItem(int img, String data) {
        this.img = img;
        this.data = data;
    }

    public int getImg() {
        return img;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CardViewItem{" +
                "img=" + img +
                ", data='" + data + '\'' +
                '}';
    }
}
