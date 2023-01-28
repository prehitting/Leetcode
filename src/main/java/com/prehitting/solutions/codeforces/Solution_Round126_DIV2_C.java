package com.prehitting.solutions.codeforces;

import java.util.Scanner;

/**
 * @ClassName Solution_Round126_DIV2_C
 * @Description from <a href="https://codeforces.com/contest/1661/problem/C">link to</a>
 * 输入t(<=2e4)表示t组数据，每组数据输入n(<=3e5)和长为n的数组h(1<=h[i]<=1e9),表示n课树的高度，所有数据的n之和不超过3e5
 * 在1，3，5，...天，可以把一棵树高度加1或者不动
 * 在2，4，6,...天，可以把一棵树高度加2或者不动
 * 至少多少天使高度一样?
 * @Author 24809
 * @Date 2023-01-24 21:38
 */
public class Solution_Round126_DIV2_C {

    private final static Scanner sc = new Scanner(System.in);

    static int t;

    static int n;

    static int[] heights;

    static int max;

    static void read() {
        max = -1;
        n = sc.nextInt();
        heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
            max = max(heights[i], max);
        }
    }

    public static void main(String[] args) {
        t = sc.nextInt();
        while (t-- > 0) {
            read();
            System.out.println(Math.min(solve(max), solve(max + 1)));
        }
    }

    static int solve(final int targetHeight) {
        int ct1 = 0, ct2 = 0;
        for (int i = 0; i < n; i++) {
            ct1 += (targetHeight - heights[i]) % 2;//所需 1 的个数
            ct2 += (targetHeight - heights[i]) / 2;//2 的个数
        }
        int tmp = ct2 - ct1;
        if (tmp >= 2) {//如果差值过多
            ct1 += (tmp + 1) / 3 * 2;
            ct2 -= (tmp + 1) / 3;
        }
        if (ct1 > ct2) {//次数
            return ct1 * 2 - 1;
        } else {
            return ct2 * 2;
        }
    }

    private static int max(int a, int b) {
        return Math.max(a, b);
    }
}
