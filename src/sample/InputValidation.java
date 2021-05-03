package sample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidation {
    public static Scanner input = new Scanner(System.in);
    public static int integerValues = 0;

    public static int integerValue(String msg){
        while(true){
            try{
                System.out.print(msg);
                integerValues = input.nextInt();
                return integerValues;
            }
            catch (InputMismatchException e) {
                System.out.println("  Integer Required..!");
                input.next();
            }
        }
    }
}
