package win.pipi.swiftemotionboard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import win.pipi.swiftemotionboard.R;

/**
 * Created by pip on 2018/1/23.
 */

public class EmptyFragment1 extends BaseFragment {

    public static EmptyFragment1 newInstance(){
        return new EmptyFragment1();
    }

    public EmptyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_empty ,container,false);
        return rootview;
    }
}
