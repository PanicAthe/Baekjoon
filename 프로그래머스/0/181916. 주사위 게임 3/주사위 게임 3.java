class Solution {
    public int solution(int a, int b, int c, int d) {
        if(a==b&&b==c&&c==d){ //네 주사위가 같은 경우
            return 1111*a;
        }else{
            //세 주사위가 같은 경우
            if(a==b&&b==c)return (10*a+d)*(10*a+d);
            if(b==c&&c==d)return (10*c+a)*(10*c+a);
            if(a==d&&d==c)return (10*a+b)*(10*a+b);
            if(a==b&&b==d)return (10*a+c)*(10*a+c);

            if(a==b){ //두 주사위가 같음
                if(c==d)return (a+c)*Math.abs(a-c); //다른 두 주사위도 같음
                return c*d; //다른 두 주사위는 다름.
            }
            if(b==c){
                if(d==a)return (a+c)*Math.abs(a-c);
                return d*a;
            }
            if(c==d){
                if(a==b)return (a+c)*Math.abs(a-c);
                return b*a;
            }
            if(a==d){
                if(b==c)return (a+c)*Math.abs(a-c);
                return c*b;
            }
            if(a==c){
                if(b==d)return (a+d)*Math.abs(a-d);
                return d*b;
            }
            if(b==d){
                if(c==a)return (a+b)*Math.abs(a-b);
                return c*a;
            }

            return Math.min(Math.min(a,b),Math.min(c,d));


        }
    }
}