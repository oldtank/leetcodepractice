package xin.interview.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/30/2016.
 */
public class Main {
    public static void main(String[] args) {
        int level = 5;
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        int curr_level = 1;
        while(curr_level <= level) {
            List<Integer> parent = curr;
            curr = new ArrayList<>();

            curr.add(1);
            for (int i=0; i<parent.size()-1; i++) {
                curr.add(parent.get(i) + parent.get(i+1));
            }
            curr.add(1);

            for (int i : curr) {
                System.out.print(i + " ");
            }
            System.out.println();

            curr_level++;
        }
    }
}
