package toDoProject.ui;

import java.util.Scanner;

public class Utils {

    private static final Scanner scannerInt = new Scanner(System.in);
    private static final Scanner scannerStr = new Scanner(System.in);

    public static Integer getInt(String hint){
        System.out.print(hint);
        return scannerInt.nextInt();
    }

    public static String getStr(String hint){
        System.out.print(hint);
        return scannerStr.nextLine();
    }
}
