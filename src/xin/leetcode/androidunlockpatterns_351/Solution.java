package xin.leetcode.androidunlockpatterns_351;

/**
 * Created by Xin on 9/4/2016.
 */
public class Solution {
    int offseti[] = {0, 0, -1, 1, 1, 1, -1, -1, 1, -1, -2, -2,-1,1,2,2};
    int offsetj[] = {-1, 1, 0, 0, 1, -1, 1, -1, 2, 2, 1,-1,-2,-2,-1,1};

    public int numberOfPatterns(int m, int n) {
        int sum=0;
//        for (int i =m; i<=n; i++) {
            int sub = 0;
            sub+= numberOfPaths(1, m, n)*4;
            sub+= numberOfPaths(4, m, n)*4;
            sub+= numberOfPaths(5, m, n);
            sum+=sub;
//        }
        return sum;

    }

    public int numberOfPaths(int start, int min, int max) {
        int matrix[][] = new int[3][3];
        boolean visited[][] = new boolean[3][3];
        visited[start/3][(start-1)%3] = true;
        return numberofPathsHelper(start/3, (start-1)%3, visited, min, max, 1);
    }

    public int numberofPathsHelper(int i, int j, boolean[][] visited, int min, int max, int curr_size) {
        if (curr_size == max) {
            return 1;
        }
        int count = curr_size >= min ? 1 : 0;
        visited[i][j] = true;
        for (int x=0; x<offseti.length; x++) {
            int nexti = i+offseti[x];
            int nextj = j+offsetj[x];
            if (isValid(nexti, nextj)) {
                if (!visited[nexti][nextj]) {
                    count += numberofPathsHelper(nexti, nextj, visited, min, max, curr_size+1);
                } else {
                    int jumpi = nexti + offseti[x];
                    int jumpj = nextj + offsetj[x];
                    if (isValid(jumpi, jumpj) && !visited[jumpi][jumpj]) {

                        count += numberofPathsHelper(jumpi, jumpj, visited, min, max, curr_size+1);
                    }
                }
            }
        }
        visited[i][j]=false;
        return count;
    }

    private boolean isValid(int i, int j) {
        return i>=0 && i<3 && j>=0 && j<3;
    }
}