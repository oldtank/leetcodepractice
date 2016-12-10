package xin.leetcode.wordsearchii_212;

/**
 * Created by Xin on 9/25/2016.
 */
public class Main {
    public static void main(String[] args) {
        String words[] = {"oath","pea","eat","rain"};
        char board[][] = {{'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}};
        System.out.println(new Solution().findWords(board,words));
    }
}
