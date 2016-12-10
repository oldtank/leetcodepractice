package xin.interview.arrangetasks;

/**
 * Created by Xin on 11/23/2016.
 */
public class Main {
    public static void main(String[] args) {
        String tasks = "AABACCDCD";
        int gap = 3;
        System.out.println(new ArrangeTasks().arrange(tasks, gap));
        System.out.println(new ArrangeTasks().rearrange(tasks, gap));
    }
}
