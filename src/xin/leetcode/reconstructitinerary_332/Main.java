package xin.leetcode.reconstructitinerary_332;

/**
 * Created by Xin on 9/3/2016.
 */
public class Main {
    public static void main(String[] args) {
//        String tickets[][] ={{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
        String tickets[][] = {{"JFK", "ATL"}, {"ATL","JFK"}};
        Solution solution = new Solution();

        System.out.println(solution.findItinerary(tickets));
    }
}
