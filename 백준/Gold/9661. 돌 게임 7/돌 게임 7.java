import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        if(N%5==2||N%5==0){
            System.out.print("CY");
        }else{
            System.out.print("SK");
        }
    }
}