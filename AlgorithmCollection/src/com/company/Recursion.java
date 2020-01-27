package com.company;

public class Recursion {

    public static int factorial(int n){
        if(n >0){
            return n * factorial(n-1);
        }else {
            return 1;
        }
    }

    //최대공약수
    public static int euclidGCD(int x, int y){
        if(y == 0){
            return x;
        }else {
            return euclidGCD(y, x % y);
        }
    }

    //재귀분석
     public static void recur(int n){
        if(n > 0){
            recur(n-1);
            System.out.println(n);
            recur(n-2);
        }
    }

    //Hanoi
    public static void hanoi(int n, int start, int end, int middle){
        if(n==1){
            System.out.println("Move start: " + start + " to : " + end);
        }else{
            hanoi(n-1,start,middle,end);
            System.out.println("Move start: " + start + " to : " + end);
            hanoi(n-1,middle,end,start);
        }
    }
}
