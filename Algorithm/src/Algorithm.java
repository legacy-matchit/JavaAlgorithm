import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Algorithm {


    private int[] numbers;
    private String[] strings;
    ArrayList<String> orderedList;
    public Algorithm(int[] numbers, String[] strings){
        this.numbers = numbers;
        this.strings = strings;
        orderedList = new ArrayList<>();
    }
    public void sort(){

        for(int i = 0; i < numbers.length; i++){
            int sortIdx = i;
            for(int j = i; j < numbers.length; j++){
                if(numbers[j] < numbers[sortIdx]){
                    sortIdx = j;
                }
            }

            int tem = numbers[i];
            numbers[i] = numbers[sortIdx];
            numbers[sortIdx] = tem;
        }

        System.out.println(Arrays.toString(numbers));

        for(int i = 0; i < strings.length; i++){
            int sortIdx = i;
            for(int j = i; j < strings.length; j++){
                if(strings[j].compareTo(strings[sortIdx]) < 0){
                    sortIdx = j;
                }
            }

            String tem = strings[i];
            strings[i] = strings[sortIdx];
            strings[sortIdx] = tem;
        }

        System.out.println(Arrays.toString(strings));

    }

    public void min(){
        int minIdx = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < numbers[minIdx]){
                minIdx = i;
            }
        }
        System.out.println(numbers[minIdx]);
    }

    public void max(){
        int maxIdx = 0;
        for (int i = 0; i < numbers.length; i++){
            if(numbers[i] > numbers[maxIdx]){
                maxIdx = i;
            }
        }
        System.out.println(numbers[maxIdx]);
    }

    public void shuffle(){
        for(int i = 0; i < strings.length; i++){
            Random random = new Random();
            int randomIdx = random.nextInt(strings.length - i);

            String tem = strings[i];
            strings[i] = strings[randomIdx];
            strings[randomIdx] = tem;
        }
        System.out.println(Arrays.toString(strings));
    }

    public void printPrimeNumber(int range){
        boolean[] b = new boolean[range];
        for(int i = 2; i < range; i++){
            if(b[i] == false){
                for(int j = i + i; j < range; j += i){
                    b[j] = true;
                }
                System.out.println(i);
            }
        }
    }

    public void testEquals(){
        Poligon p1 = new Poligon(1,1);
        Poligon p2 = new Poligon(1,1);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        ArrayList<Poligon> poligons = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            poligons.add(new Poligon(i,i));
        }

        System.out.println(poligons.indexOf(p1));
        System.out.println(poligons.contains(p1));
        System.out.println(poligons.remove(p1));
        System.out.println(poligons.contains(p1));

    }

    public ArrayList<String> orderedInsert(String s){
        orderedList.add(s);

        for(int i = 0; i < orderedList.size(); i++){

            int sortIdx = i;

            for(int j = i; j < orderedList.size(); j++){
                if(orderedList.get(j).compareTo(orderedList.get(sortIdx)) < 0){
                    sortIdx = j;
                }
            }

            String tem = orderedList.get(i);
            orderedList.set(i,orderedList.get(sortIdx));
            orderedList.set(sortIdx,tem);
        }

        System.out.println(orderedList.toString());
        return orderedList;
    }

    public ArrayList<String> orderedAdding(String s){
        int position =0;
        while (position < orderedList.size() &&
        orderedList.get(position).compareTo(s) <  0){
            position++;
        }
        orderedList.add(position,s);
        System.out.println(orderedList.toString());
        return orderedList;
    }


    public static char encrypt(char c){
        if(c >= 'A' && c<= 'M' || c >= 'a' && c <='m'){
            c = (char) (c  + 13);
        }else if(c >= 'N' && c <= 'Z' || c >= 'n' && c <='z'){
            c = (char) (c  - 13);
        }
        return c;
    }

    public static String encrypt(String s){
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            c = encrypt(c);
            b.append(c);
        }
        return b.toString();
    }

    public char getRandomAlphabet(){
        Random r = new Random();
        int rNbr = r.nextInt(26);
        return (char)(rNbr + 65);
    }

    public void snailArray(int n){
        int[][] array = new int[n][n];

        int row=0,col=-1; //* 컬럼초기값 -1
        int value = 1; // index로 사용가능 0부
        int inc = 1;

        while (n > 0){

            for(int i = 0; i < n; i++){
                col += inc;
                array[row][col] = value;
                value++;
            }
            n--;
            if(n == 0){
                break;
            }

            for (int i = 0; i < n; i++){
                row += inc;
                array[row][col] = value;
                value++;
            }
            inc *= -1;

        }

        for (int i = 0; i < array.length; i++){
            System.out.println();

            for (int j = 0; j < array[i].length; j++){
                System.out.print("[  " + array[i][j] + "  ]");
            }

            System.out.println();
        }
    }
}


class Poligon{
    private int x;
    private int y;
    Poligon(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Poligon)){
            return false;
        }
        Poligon p = (Poligon)obj;
        return this.x == p.x && this.y == p.y;
    }
}