import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
//        WorkShift w = new WorkShift(false,"2019-06-24",10,12);
//        System.out.println(w.toString());
//        System.out.println(w.getDateAsString());
//        System.out.println(w.getDay());
//        System.out.println(w.getLength());
//        System.out.println(w.getMonth());
//
//        WorkShift w1 = new WorkShift(false,"2019-06-24",10,12);
//        WorkShift w2 = new WorkShift(false,"2019-06-22",10,12);
//        WorkShift w3 = new WorkShift(false,"2019-06-21",10,12);
//        WorkShift w4 = new WorkShift(false,"2019-06-27",10,12);
//        WorkShift w5 = new WorkShift(false,"2019-07-24",10,12);
//        WorkShift w6 = new WorkShift(false,"2019-06-23",10,12);
//        WorkShift w7 = new WorkShift(false,"2019-06-26",10,12);
//
//        TeachingAssistant t = new TeachingAssistant("wooram","2222");
//        t.addShift(false,"2019-06-24",10,12);
//        t.addShift(false,"2019-06-22",10,12);
//        t.addShift(false,"2019-06-21",10,12);
//        t.addShift(false,"2019-06-27",10,12);
//        t.addShift(false,"2019-07-23",10,12);
//
//        System.out.println(t.getTeachingShiftsForMonth(6));
//        System.out.println(t.getNbrOfDaysForMonth(6));
//        System.out.println(t.getTotalPaymentForMonth(6));

        Scanner scan = null;
        try{
            scan = new Scanner(new File("src/input.txt"));
        }catch (FileNotFoundException e){
            System.out.println("File is not exist");
            System.exit(0);
        }

        PaymentGenerator pay = new PaymentGenerator(scan);
        Scanner s = new Scanner(System.in);
        System.out.println("put in month");
        int month = s.nextInt();
        while (month > 12 || month < 1){
            System.out.println("put in correct month");
            month = s.nextInt();
        }
        pay.printShiftsForMonth(month);
    }
}
