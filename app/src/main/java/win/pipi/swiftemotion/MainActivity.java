package win.pipi.swiftemotion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import win.pipi.swiftemotionboard.fragment.EmotionMainFragment;

public class MainActivity extends AppCompatActivity {


    private static final String PRE="file:///android_asset/default_emotions/";
    private static List<String> list=new ArrayList<>();
    private static Map<String,List<String>> emotions=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTestEmotion();

        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        EmotionMainFragment fragment= EmotionMainFragment.newInstance();
        fragment.setupTextEmotionBlocks(list,emotions,null);

        transaction.replace( R.id.emotion_position,fragment);

        transaction.commit();
    }

    void initTestEmotion(){

        List<String> aBlockEmotion=new ArrayList<>();
        aBlockEmotion.add(PRE+"01.png");
        aBlockEmotion.add(PRE+"02.png");
        for(int i=0;i<5;i++){
            String string="表情 "+i;
            list.add(string);
            emotions.put(string,aBlockEmotion);
        }


    }
}
