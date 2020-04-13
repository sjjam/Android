package multi.android.support_lib.fragment.exam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import multi.android.support_lib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class view3 extends Fragment {

    public view3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return inflater.inflate(R.layout.view3, container, false);
    }
}
