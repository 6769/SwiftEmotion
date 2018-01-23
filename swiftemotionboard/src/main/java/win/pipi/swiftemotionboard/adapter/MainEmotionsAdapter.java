package win.pipi.swiftemotionboard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by pip on 2018/1/23.
 */

public class MainEmotionsAdapter extends FragmentPagerAdapter {

    public MainEmotionsAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    private List<Fragment> fragments;
    @Override
    public int getCount() {
        return fragments==null? 0:fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}
