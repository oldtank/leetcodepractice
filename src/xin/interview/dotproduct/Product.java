package xin.interview.dotproduct;

import java.util.Map;

/**
 * Created by Xin on 11/25/2016.
 */
public class Product {
    public int calculate(Map<Integer, Integer> vector1, Map<Integer, Integer> vector2) {
        int result = 0;
        for (Integer pos : vector1.keySet()) {
            if (vector2.containsKey(pos)) {
                result += vector1.get(pos) * vector2.get(pos);
            }
        }
        return result;
    }
}
