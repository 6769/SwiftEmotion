package win.pipi.swiftemotion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import win.pipi.swiftemotionboard.fragment.Communicator;
import win.pipi.swiftemotionboard.fragment.EmotionMainFragment;
import win.pipi.swiftemotionboard.model.EmotionGroup;
import win.pipi.swiftemotionboard.model.OneEmotion;

public class MainActivity extends AppCompatActivity implements Communicator {

    private static final String TAG=MainActivity.class.getSimpleName();

    private static final String PRE="file:///android_asset/default_emotions/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        EmotionMainFragment fragment= EmotionMainFragment.newInstance();
        fragment.setupTextEmotionBlocks(initTestEmotion(),this);

        transaction.replace( R.id.emotion_position,fragment);

        transaction.commit();
    }

    List<EmotionGroup> initTestEmotion(){

        OneEmotion e1=new OneEmotion(PRE+"01.png","hello");
        OneEmotion e2=new OneEmotion(PRE+"02.png","world");

        List<OneEmotion> emotionList=new ArrayList<>();
        for(int i=0;i<10;i++){
            emotionList.add(e1);
            emotionList.add(e2);
        }



        List<EmotionGroup> emotionGroups=new ArrayList<>();
        for(int i=0;i<5;i++){
            String string="表情 "+i;
            EmotionGroup emotionGroup=new EmotionGroup(string,emotionList);
            emotionGroups.add(emotionGroup);
        }

        return emotionGroups;


    }

    @Override
    public void setText(String clicked) {
        Log.i(TAG, "setText: "+clicked);
    }
}
