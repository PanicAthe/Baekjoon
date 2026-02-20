import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        if(N%7!=0 && N%7!=2){
            System.out.print("SK");
        }else{
            System.out.print("CY");
        }
    }
}