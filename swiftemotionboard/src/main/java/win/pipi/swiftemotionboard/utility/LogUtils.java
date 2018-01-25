package win.pipi.swiftemotionboard.utility;

import com.orhanobut.logger.Logger;

/**
 * Created by pip on 2018/1/25.
 */

public class LogUtils {
    private static final String TAG="swiftemotionboard";

    public static void w(String msg){
        Logger.t(TAG).w(msg);
    }
    public static void i(String msg){
        Logger.t(TAG).i(msg);
    }
    public static void d(String msg){
        Logger.t(TAG).d(msg);
    }
}
