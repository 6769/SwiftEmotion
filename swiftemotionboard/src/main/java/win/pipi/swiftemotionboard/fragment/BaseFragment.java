package win.pipi.swiftemotionboard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by pip on 2018/1/23.
 */

public class BaseFragment extends Fragment {
    protected Bundle args;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
    }
}
