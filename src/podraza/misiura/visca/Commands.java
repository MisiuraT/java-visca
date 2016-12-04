package podraza.misiura.visca;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tomek on 04.12.2016.
 */
public class Commands {
    private static Map<String,String> cmdMap = new HashMap<String,String>();
    static{
        cmdMap.put("LEFT","8101060106060103FF");
        cmdMap.put("RIGHT","8101060106060203FF");
        cmdMap.put("UP","8101060106060301FF");
        cmdMap.put("DOWN","8101060106060302FF");
        cmdMap.put("ON","8101040002FF");
        cmdMap.put("OFF","8101060106060302FF");
        cmdMap.put("ZoomWide","8101040703");
        cmdMap.put("ZoomTele","8101040702");
    }
    public static String getCommand(String cmd){
        return cmdMap.get(cmd);
    }
}
