package xin.leetcode.phonedirectory_379;

/**
 * Created by Xin on 9/6/2016.
 */
public class Mian {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory(1);
        System.out.println(phoneDirectory.check(0));
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.check(0));
        System.out.println(phoneDirectory.get());
    }
}
