package win.pipi.swiftemotionboard.fragment;

import java.util.List;
import java.util.Map;

import win.pipi.swiftemotionboard.model.EmotionGroup;

/**
 * Created by pip on 2018/1/23.
 */

public class EmotionBlockFactory {
    private static EmotionBlockFactory factory;
    private EmotionBlockFactory() {
    }


    /**
     * 双重检查锁，获取工厂单例对象
     * @return EmotionBlockFactory
     */
    public static EmotionBlockFactory getSingleInstance(){
        if (factory==null){
            synchronized (EmotionBlockFactory.class){
                if(factory==null){
                    factory=new EmotionBlockFactory();
                }
            }
        }
        return factory;

    }
    public EmotionBlockFragment getFragment(EmotionGroup group, Communicator communicator){
        EmotionBlockFragment emotionBlockFragment=EmotionBlockFragment.newInstance();
        emotionBlockFragment.setEmotions(group);
        emotionBlockFragment.setCommunicator(communicator);

        return emotionBlockFragment;
    }
}
