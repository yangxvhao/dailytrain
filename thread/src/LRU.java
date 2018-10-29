import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yangxvhao
 * @date 2018-10-25 下午3:16.
 */
public class LRU extends LinkedHashMap {
    public LRU() {
        super();
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        if(size() > 6)
            return true;
        return false;
    }
}
