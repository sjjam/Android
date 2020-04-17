package multi.android.material_design_pro2.recycler;

public class CircleItem {
    int img;

    public CircleItem(int imgdata) {
        this.img = imgdata;
    }

    public int getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "CircleItem{" +
                "img=" + img +
                '}';
    }
}
