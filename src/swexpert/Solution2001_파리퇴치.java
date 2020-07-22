package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2001_파리퇴치 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] A = new int[100][100];
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            for (int[] ints : A) {
                Arrays.fill(ints, 0);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for (int i = 0; i < N - M + 1 ; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int sum = 0;
                    for (int row = i; row < i + M; row++) {
                        for (int col = j; col < j + M; col++) {
                            sum += A[row][col];
                        }
                    }
                    max = Math.max(sum, max);
                } // end of j
            } // end of i

            System.out.println("#" + tc + " " + max);
        } // end of for_tc
    }
}