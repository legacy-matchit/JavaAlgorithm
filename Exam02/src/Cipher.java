import java.util.Random;
import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        long password = scan.nextLong();
        Random rand = new Random(password);
        for (int i = 0; i < message.length(); i++) {
            char ch = (char) (message.charAt(i) + rand.nextInt(128));
            if (ch >= 128) {
                ch -= 128;
            }
            System.out.print(ch);
        }
    }
}
