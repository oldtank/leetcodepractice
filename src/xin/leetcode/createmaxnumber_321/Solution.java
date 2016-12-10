package xin.leetcode.createmaxnumber_321;

import java.util.ArrayDeque;

/**
 * Created by Xin on 9/21/2016.
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (k==0 || k > nums1.length + nums2.length) {
            return new int[0];
        }

        int max = -1;
        for (int i=0; i<=k; i++) {
            if (i<=nums1.length && (k-i) <= nums2.length) {
                int max1 = createMax(nums1, i);
                int max2 = createMax(nums2, k-i);
                System.out.println("i: "+i);
                System.out.println("num1: "+max1);
                System.out.println("num2: "+max2);
                if (i == 0) {
                    max = Math.max(max, max2);
                } else if (k-i == 0) {
                    max = Math.max(max, max1);
                } else {
                    int merge = merge(max1, max2);
                    System.out.println("merge: "+merge);
                    max = Math.max(max, merge);
                }
                System.out.println("max: "+max);
            }
        }
        int[] result = new int[k];
        int i = k-1;
        while(max > 0) {
            result[i] = max%10;
            max/=10;
            i--;
        }
        return result;
    }

    public int merge(int n1, int n2) {
        StringBuilder sb = new StringBuilder();
        String s1 = Integer.toString(n1);
        String s2 = Integer.toString(n2);

        int i=0, j=0;
        while (i<s1.length() && j<s2.length()) {
            if (s1.charAt(i) < s2.charAt(j)) {
                sb.append(s2.charAt(j));
                j++;
            } else if (s1.charAt(i) > s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
            } else {
                int x=i+1, y=j+1;
                while (x<s1.length() && y<s2.length()) {
                    if (s1.charAt(x) < s2.charAt(y)) {
                        sb.append(s2.charAt(j));
                        j++;
                        break;
                    } else if (s1.charAt(x) > s2.charAt(y)) {
                        sb.append(s1.charAt(i));
                        i++;
                        break;
                    } else {
                        x++;
                        y++;
                    }
                }
                if (x == s1.length()) {
                    sb.append(s2.charAt(j));
                    j++;
                } else if (y == s2.length()) {
                    sb.append(s1.charAt(i));
                    i++;
                }
            }
        }

        if (i == s1.length()) {
            for (int m=j; m<s2.length(); m++) {
                sb.append(s2.charAt(m));
            }
        } else if (j == s2.length()) {
            for (int m=i; m<s1.length(); m++) {
                sb.append(s1.charAt(m));
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public int createMax(int[] nums, int digits) {
        if (digits == 0) {
            return 0;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i=0; i< nums.length; i++) {
            if (queue.isEmpty()) {
                queue.addLast(nums[i]);
            } else if (nums[i] <= queue.getLast()) {
                if (queue.size() < digits) {
                    queue.addLast(nums[i]);
                }
            } else {
                while (!queue.isEmpty() && nums.length-1-i+1+queue.size()-1 >= digits && nums[i] > queue.getLast()) {
                    queue.removeLast();
                }
                queue.addLast(nums[i]);
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            result = result*10 + queue.getFirst();
            queue.removeFirst();
        }
        return result;
    }
}