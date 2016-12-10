package xin.leetcode.palindromepairs_336;

import java.util.*;

/**
 * Created by Xin on 9/18/2016.
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        }
        Map<String, Integer> wordToIndex = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            wordToIndex.put(words[i], i);
        }

        for (int i=0; i<words.length; i++) {
            if (isPalindrome(words[i])) {
                if (!words[i].equals("")) {
                    if (wordToIndex.containsKey("")) {
                        List<Integer> l = new ArrayList<>();
                        l.add(i);
                        l.add(wordToIndex.get(""));
                        list.add(l);

                        List<Integer> l1 = new ArrayList<>();
                        l1.add(wordToIndex.get(""));
                        l1.add(i);
                        list.add(l1);
                    }
                }
            } else {

                String r = reverse(words[i]);
                if (wordToIndex.containsKey(r)) {
                    System.out.println(words[i] + "+" + r);
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(wordToIndex.get(r));
                    list.add(l);
                }
            }


                for (int j=1; j<words[i].length(); j++) {
                    String left = words[i].substring(0, j);
                    String right = words[i].substring(j);
                    System.out.println("left: "+left +"; right: "+right);
                    if(isPalindrome(left)) {
                        String reverse = reverse(right);
                        if (wordToIndex.containsKey(reverse)) {
                            System.out.println(reverse + " + " + words[i] );
                            List<Integer> l = new ArrayList<>();
                            l.add(wordToIndex.get(reverse));
                            l.add(i);
                            list.add(l);
                        }
                    }
                    if (isPalindrome(right)) {
                        String reverse = reverse(left);
                        if (wordToIndex.containsKey(reverse)) {
                            System.out.println(words[i] + " + " + reverse);
                            List<Integer> l = new ArrayList<>();
                            l.add(i);
                            l.add(wordToIndex.get(reverse));
                            list.add(l);
                        }
                    }
                }

        }
        return list;
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}