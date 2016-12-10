package xin.interview.parenthesiswithsmiley;

/**
 * Created by Xin on 11/26/2016.
 */
public class Main {
    public static void main(String[] args) {
        String[] chats = {":((", "I am sick today (:()", "(:)", "hacker up: started :) :)", ")("};
        Solution solution = new Solution();
        for (String chat : chats) {
            System.out.println(chat + " --> " + solution.verify(chat));
        }
    }
}
