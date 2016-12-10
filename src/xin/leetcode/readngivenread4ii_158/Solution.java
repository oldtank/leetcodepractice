package xin.leetcode.readngivenread4ii_158;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.jar.Pack200;

/**
 * Created by Xin on 9/18/2016.
 */
public class Solution extends Reader4 {
    Queue<Character> queue = new ArrayDeque<>();
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n==0) {
            return 0;
        }

        int totalRead = 0;
        while (!queue.isEmpty() && n >0) {
            buf[totalRead++] = queue.poll();
            n--;
        }

        boolean eof = false;
        while (n > 0 && !eof) {
            char tmp[] = new char[4];
            int readCount = read4(tmp);
            if (readCount < 4) {
                eof = true;
            }
            if (n >= readCount) {
                for (int i=0; i<readCount; i++) {
                    buf[totalRead++] = tmp[i];
                    n--;
                }
            } else {
                for (int i=0; i<n; i++) {
                    buf[totalRead++] = tmp[i];
                    n--;
                }
                for (int i=n; i<readCount; i++) {
                    queue.offer(tmp[i]);
                }
            }
        }
        return totalRead;
    }
}