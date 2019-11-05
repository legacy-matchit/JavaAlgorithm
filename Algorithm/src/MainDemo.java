import java.util.Arrays;

public class MainDemo {
    public static void main(String[] args){
        int[] numbers = {9,4,2,3,6,7,5,8,1};
        String[] strings = {"apple","citron","baby","pen","note","pay","date"};
        Algorithm algorithm = new Algorithm(numbers, strings);
        System.out.println("------------------");
        algorithm.sort();
        System.out.println("------------------");
        algorithm.min();
        System.out.println("------------------");
        algorithm.max();
        System.out.println("------------------");
        algorithm.printPrimeNumber(100);

        for(int i = 0; i < 50; i++){
            algorithm.shuffle();
        }

        algorithm.testEquals();

        algorithm.orderedAdding("ddd");
        algorithm.orderedAdding("fff");
        algorithm.orderedAdding("sss");
        algorithm.orderedAdding("ttt");
        algorithm.orderedAdding("aaa");
        algorithm.orderedAdding("ccc");
        algorithm.orderedAdding("bbb");

        System.out.println(Algorithm.encrypt("JAVA Programing"));

        for(int i = 0; i < 100; i++){
            System.out.print(algorithm.getRandomAlphabet());
        }

        algorithm.snailArray(5);
    }
}
