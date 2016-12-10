package xin.interview.arrangetasks;

import java.util.*;

/**
 * Created by Xin on 11/23/2016.
 */
public class ArrangeTasks {
    public String arrange(String tasks, int gap) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> lastPos = new HashMap<>();
        int currPos = 0;
        for (int i=0; i<tasks.length(); i++) {
            char c = tasks.charAt(i);
            if (!lastPos.containsKey(c)) {
                sb.append(c);
            } else {
                for (int j=0; j<(gap+1-(currPos - lastPos.get(c))); j++ ) {
                    sb.append('_');
                }
                sb.append(c);
            }
            currPos = sb.length();
            lastPos.put(c, currPos-1);
        }
        return sb.toString();
    }



    public String rearrange(String tasks, int gap) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<tasks.length(); i++) {
            char c = tasks.charAt(i);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c)+1);
        }
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> (b.count - a.count));
        map.entrySet().forEach(entry -> pq.offer(new Task(entry.getKey(), entry.getValue())));
        Queue<Task> waitQueue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty() || !waitQueue.isEmpty()) {
            if (pq.isEmpty()) {
                int gaps = gap + 1 - waitQueue.size();
                while (!waitQueue.isEmpty() && waitQueue.peek().count == 0) {
                    waitQueue.poll();
                }
                if (waitQueue.isEmpty()) {
                    break;
                } else {
                    for (int i = 0; i < gaps; i++) {
                        sb.append('_');
                        waitQueue.add(new Task('_', 0));
                    }
                    pq.offer(waitQueue.poll());
                }
            } else {
                Task curr = pq.poll();
                sb.append(curr.task);
                curr.count--;

                waitQueue.add(curr);
                if (waitQueue.size() <= gap) {
                    continue;
                } else {
                    Task front = waitQueue.poll();
                    if (front.count > 0) {
                        pq.offer(front);
                    }
                }
            }
        }

        return sb.toString();
    }
}
