package com.company;

import org.w3c.dom.Node;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] sample = {5,4,6,3,2,1,7,8,9,10};

        //System.out.println(Arrays.toString(Algorithm.selectionSort(sample)));
        //System.out.println(Arrays.toString(Algorithm.bubbleSort(sample)));
        //System.out.println(Arrays.toString(Algorithm.insertionSort(sample)));

        //System.out.println(Recursion.factorial(5));
        //System.out.println(Recursion.euclidGCD(13,100000)); //두수의 최대공약수
        //Recursion.recur(5);

        /*
        Tree t = new Tree();
        /*Tree.Node n4 = t.makeNode(4,null,null);
        Tree.Node n5 = t.makeNode(5,null,null);
        Tree.Node n2 = t.makeNode(2,n4,n5);
        Tree.Node n3 = t.makeNode(3,null,null);
        Tree.Node n1 = t.makeNode(1,n2,n3);
        Tree.Node n30 = t.makeNode(30,null,null);
        Tree.Node n10 = t.makeNode(10,null,null);
        Tree.Node n47 = t.makeNode(47,n30,null);
        Tree.Node n20 = t.makeNode(20,n10,n47);
        t.setRoot(n20);
        t.inorder(t.getRoot()); // 42513
        t.preorder(t.getRoot()); // 12453
        t.postorder(t.getRoot()); // 45231 */


        System.out.println(Arrays.toString(sample));
        Algorithm.mergeSort(sample);
        System.out.println(Arrays.toString(sample));
       // System.out.println(Arrays.toString(Algorithm.quickSort(sample)));
    }
}
