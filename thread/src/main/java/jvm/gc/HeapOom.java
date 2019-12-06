package jvm.gc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *  -Xms20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError
 * @author yangxuhao
 * @date 2019-12-02 16:22.
 */
public class HeapOom {
    static class OomObjec{}

    public static void main(String[] args) {
        List<OomObjec> list = new ArrayList<>();
        while (true){
            list.add(new OomObjec());
        }
    }

    public static double mathRound(Double num){
        BigDecimal bigDecimal = new BigDecimal(num == null ? 0 : num);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    
}
