package xin.interview.findwaterinaglass_geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/find-water-in-a-glass/.
 */
public class FindWater {
    public double find(int water, int row, int index) {
        List<Double> curr = new ArrayList<>();
        curr.add(water+0.0);

        // list contains amount of water before spilling
        int curr_row = 2;
        while (curr_row <= row) {
            List<Double> upper = curr;
            curr = new ArrayList<>();
            curr.add(Math.max(upper.get(0)-1, 0)/2);
            for (int i=0; i<upper.size()-1; i++) {
                curr.add(Math.max(upper.get(i)-1, 0)/2 + Math.max(upper.get(i+1)-1, 0)/2);
            }
            curr.add(Math.max(upper.get(upper.size()-1)-1, 0)/2);
            curr_row ++;
        }

        return Math.min(curr.get(index),1);
    }
}
