package ap.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ap.com.clock.ClockActivity;
import ap.com.email.EmailActivity;
import ap.com.video.VideoActivity;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class AddUtils {

    public static Map<String, Class<?>> map = new HashMap<>();

    public static List<String> getList() {

        map.put("video", VideoActivity.class);
        map.put("clock", ClockActivity.class);
        map.put("Email", EmailActivity.class);

        List<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            list.add(str);
        }
        return list;
    }
}
