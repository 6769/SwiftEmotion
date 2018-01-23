package win.pipi.swiftemotionboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import win.pipi.swiftemotionboard.R;


public class EmotionBlockFragment extends BaseFragment {

    private List<String> emotions=new ArrayList<>();
    private Communicator communicator;


    public EmotionBlockFragment() {
        // Required empty public constructor
    }

    public static EmotionBlockFragment newInstance() {
        EmotionBlockFragment fragment = new EmotionBlockFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emotion_block, container, false);
    }

    public void setEmotions(List<String> list){
        emotions.clear();
        emotions.addAll(list);
    }
    public void setCommunicator(Communicator communicator1){
        communicator=communicator1;
    }

}
