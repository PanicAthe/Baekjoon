class Solution {
    // 최대공약수(GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int commonDenom = denom1 * denom2;
        int newNumer = numer1 * denom2 + numer2 * denom1;

        int n = gcd(newNumer, commonDenom);
        return new int[]{newNumer / n, commonDenom / n};
    }
}
