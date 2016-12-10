package xin.interview.shufflecard;

/**
 * Created by Xin on 8/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        String card = "ABCDE";
        String shuffle= "43210";
        System.out.println(shufflesNeeded(card, shuffle));
//        System.out.println(shuffle(card, shuffle));
//        card = shuffle(card, shuffle);
//        System.out.println(shuffle(card, shuffle));
//        card = shuffle(card, shuffle);
//        System.out.println(shuffle(card, shuffle));
//        card = shuffle(card, shuffle);
//        System.out.println(shuffle(card, shuffle));
//        card = shuffle(card, shuffle);
//        System.out.println(shuffle(card, shuffle));
//        card = shuffle(card, shuffle);
//        System.out.println(shuffle(card, shuffle));
//        card = shuffle(card, shuffle);
//        System.out.println(shuffle(card, shuffle));
    }

    public static String shuffle(String card, String shuffle) {
        char s[] = new char[shuffle.length()];
        for (int i=0; i<shuffle.length(); i++) {
            s[Integer.parseInt((""+ shuffle.charAt(i)))] = card.charAt(i);
        }
        return new String(s);
    }

    public static int shufflesNeeded(String card, String shuffle) {
        int shufflesNeeded[] = new int[card.length()];
        for (int i=0; i<card.length(); i++) {
            int curr = Integer.parseInt((""+ shuffle.charAt(i))), count=1;
            while (curr != i) {
                curr = Integer.parseInt((""+ shuffle.charAt(curr)));
                count++;
            }
            shufflesNeeded[i] = count;
        }
        return smallestCommonMulti(shufflesNeeded, 0, shufflesNeeded.length-1);
    }

    public static int smallestCommonMulti(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int scm_left = smallestCommonMulti(nums, start, (start+end)/2);
        int scm_right = smallestCommonMulti(nums, (start+end)/2+1, end);
        return (scm_left*scm_right/GCD(scm_left, scm_right));
    }

    public static int GCD(int m, int n) {
        if (m==n) {
            return m;
        }
        if (m < n) {
            return GCD(n, m);
        }
        if (m%n==0) {
            return n;
        } else {
            return GCD(n, m%n);
        }
    }
}
