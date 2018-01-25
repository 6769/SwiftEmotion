package win.pipi.swiftemotionboard.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import win.pipi.swiftemotionboard.R;
import win.pipi.swiftemotionboard.R2;
import win.pipi.swiftemotionboard.adapter.AEmotionAdapter;
import win.pipi.swiftemotionboard.model.EmotionGroup;


public class EmotionBlockFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R2.id.emotion_block_recyclerview)
    RecyclerView emotionBlockRecyclerview;


    private EmotionGroup group;
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
        View view = inflater.inflate(R.layout.fragment_emotion_block, container, false);
        unbinder = ButterKnife.bind(this, view);

        AEmotionAdapter adapter=new AEmotionAdapter(getContext(),group,communicator);
        emotionBlockRecyclerview.setLayoutManager(new GridLayoutManager(getContext(),6));
        emotionBlockRecyclerview.setHasFixedSize(true);//lock size;
        emotionBlockRecyclerview.setAdapter(adapter);

        return view;
    }

    public void setEmotions(EmotionGroup emotionGroup) {
        group=emotionGroup;
    }

    public void setCommunicator(Communicator communicator1) {
        communicator = communicator1;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
