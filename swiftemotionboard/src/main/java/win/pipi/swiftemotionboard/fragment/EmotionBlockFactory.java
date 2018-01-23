package win.pipi.swiftemotionboard.fragment;

import java.util.List;
import java.util.Map;

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
    public EmotionBlockFragment getFragment(List<String> list,Communicator communicator){
        EmotionBlockFragment emotionBlockFragment=EmotionBlockFragment.newInstance();
        emotionBlockFragment.setEmotions(list);
        emotionBlockFragment.setCommunicator(communicator);

        return emotionBlockFragment;
    }
}
