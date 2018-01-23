package win.pipi.swiftemotionboard.fragment;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import win.pipi.swiftemotionboard.R;
import win.pipi.swiftemotionboard.R2;
import win.pipi.swiftemotionboard.adapter.MainEmotionsAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmotionMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmotionMainFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R2.id.emotions_container_view_pager)
    ViewPager emotionsContainerViewPager;
    @BindView(R2.id.emotions_container_view_pager_magic_indicator)
    MagicIndicator emotionsContainerViewPagerMagicIndicator;
    Unbinder unbinder;



    private Resources resources;
    private Communicator communicator;
    private int dataType=0;
    private Map<String,List<String>> emotionsMap=new HashMap<>();
    private List<String> mIndictorTitle =new ArrayList<>();
    private List<Fragment> fragmentList=new ArrayList<>();


    public EmotionMainFragment() {}


    public static EmotionMainFragment newInstance() {
        EmotionMainFragment fragment = new EmotionMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }








    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resources=getResources();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_emotion_containers, container, false);
        unbinder = ButterKnife.bind(this, rootview);

        initData();
        initViewPager();
        initMagicIndictor();

        return rootview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initData(){

        switch (dataType){
            case 0:
                for(int i=0;i<mIndictorTitle.size();i++){

                    //TODO:use title and emotion Maps;
                    fragmentList.add(EmptyFragment1.newInstance());
                }
                break;
            default:break;
        }


    }


    public void setupTextEmotionBlocks(List<String> titles, Map<String,List<String>> emotions, Communicator communicator1){
        dataType=0;
        mIndictorTitle.clear();
        mIndictorTitle.addAll(titles);

        emotionsMap.clear();
        emotionsMap.putAll(emotions);

        communicator = communicator1;
    }



    private void initViewPager(){
        MainEmotionsAdapter adapter=new MainEmotionsAdapter(getFragmentManager(),fragmentList);
        emotionsContainerViewPager.setAdapter(adapter);
        emotionsContainerViewPager.setOffscreenPageLimit(mIndictorTitle.size());
        //cache all the emotion fragments;
    }
    private void initMagicIndictor(){
        emotionsContainerViewPagerMagicIndicator.setBackgroundColor(
                resources.getColor(R.color.emotion_text_indictor_background));
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new EmotionBlockTextNavigator());
        emotionsContainerViewPagerMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(emotionsContainerViewPagerMagicIndicator, emotionsContainerViewPager);
    }


    protected class EmotionBlockTextNavigator extends CommonNavigatorAdapter{
        @Override
        public int getCount() {
            return mIndictorTitle == null ? 0 : mIndictorTitle.size();
        }

        @Override
        public IPagerTitleView getTitleView(Context context, final int index) {
            SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
            simplePagerTitleView.setText(mIndictorTitle.get(index));
            simplePagerTitleView.setNormalColor(resources.getColor(R.color.emotion_text_indictor_normal));
            simplePagerTitleView.setSelectedColor(Color.WHITE);
            simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emotionsContainerViewPager.setCurrentItem(index,true);
                }
            });
            return simplePagerTitleView;
        }

        @Override
        public IPagerIndicator getIndicator(Context context) {
            LinePagerIndicator indicator = new LinePagerIndicator(context);
            indicator.setColors(resources.getColor(R.color.emotion_text_indictor_indicator));
            return indicator;
        }
    }


    private static final int[] IMAGE_INDICTOR={};
    @Deprecated
    protected class EmotionBlockImgNavigator extends CommonNavigatorAdapter {
        @Override
        public int getCount() {
            return mIndictorTitle.size();
        }
        @Override
        public IPagerTitleView getTitleView(Context context, final int index) {
            CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);

            // load custom layout
            View customLayout = LayoutInflater.from(context).inflate(R.layout.emotion_blocks_indictor, null);
            final ImageView titleImg = customLayout.findViewById(R.id.emotion_block_indictor_imageview);
            titleImg.setImageResource(IMAGE_INDICTOR[index]);
            commonPagerTitleView.setContentView(customLayout);

            commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                @Override
                public void onLeave(int i, int i1, float v, boolean b) {

                }

                @Override
                public void onEnter(int i, int i1, float v, boolean b) {

                }

                @Override
                public void onSelected(int index, int totalCount) {
                    //titleText.setTextColor(Color.WHITE);
                }

                @Override
                public void onDeselected(int index, int totalCount) {
                    //titleText.setTextColor(Color.LTGRAY);
                }

            });

            commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emotionsContainerViewPager.setCurrentItem(index);
                }
            });

            return commonPagerTitleView;
        }


        @Override
        public IPagerIndicator getIndicator(Context context) {
            return null;
        }


    }


}
