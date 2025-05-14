class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public int solution(int a, int b) {
        //a /= gcd(a, b);
        b /= gcd(a, b);

        while(b%5==0){
            b/=5;
        }
        while(b%2==0){
            b/=2;
        }

        return (b==1)? 1:2;
    }
}