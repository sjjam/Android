package exam.day03.view.selectview.view.adapter;

import java.util.ArrayList;

import exam.day03.view.selectview.R;

public class ActorItem {
    int myImg;
    String name;
    String date;
    String comment;

    public ActorItem(int myImg, String name, String date, String comment) {
        this.myImg = myImg;
        this.name = name;
        this.date = date;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "myImg=" + myImg +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", coment='" + comment + '\'' +
                '}';
    }
}
