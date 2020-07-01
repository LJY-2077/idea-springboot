package test;

import java.util.Scanner;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);

        Color color = Color.valueOf(str);
        System.out.println(color);
        System.out.println(Color.Blue.toString());
        scanner.close();
    }
}
