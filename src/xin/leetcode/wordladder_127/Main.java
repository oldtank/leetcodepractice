package xin.leetcode.wordladder_127;

import java.util.*;

/**
 * Created by Xin on 8/25/2016.
 */
public class Main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String wordarray[] = {"hot","dot","dog","lot","log"};
        Set<String> wordList = new HashSet<>();
        for(String word : wordarray) {
            wordList.add(word);
        }
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        HashSet<String> dic = new HashSet<>(wordList);
        dic.add(endWord);
        HashSet<String> visited = new HashSet<>();
        Map<String, Integer> depth = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        depth.put(beginWord, 1);
        visited.add(beginWord);
        queue.add(beginWord);

        while(!queue.isEmpty()) {
            String curr = queue.poll();
            for (String connected : getConnectedWords(curr, dic)) {
                if (connected.equals(endWord)) {
                    return depth.get(curr) + 1;
                }
                if (!visited.contains(connected) ) {
                    queue.add(connected);
                    depth.put(connected, depth.get(curr) + 1);
                    visited.add(connected);
                }
            }
        }
        return 0;
    }

    public static Set<String> getConnectedWords(String word, HashSet<String> dic) {
        StringBuilder sb = new StringBuilder(word);
        Set<String> connected = new HashSet<String>();
        for (int i=0; i<word.length(); i++) {
            for (char c='a'; c<='z'; c++) {
                if (c!=word.charAt(i)) {
                    sb.setCharAt(i, c);
                    if (dic.contains(sb.toString())) {
                        connected.add(sb.toString());
                    }
                }
            }
            sb.setCharAt(i, word.charAt(i));
        }
        return connected;
    }
}
