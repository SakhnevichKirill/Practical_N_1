import openandread.FileWork;

import java.io.IOException;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s;
        boolean f = true;
        FileWork fileWork = new FileWork(f);

        while (f){
            System.out.println("1 - read; 2 - write \"2 ...\"");
            s = sc.nextLine().split("\\s+");
            switch (s[0]) {
                case ("1") -> {
                    fileWork.printFile();
                }
                case ("2") -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 1; i < s.length; i++) {
                        stringBuilder.append(s[i]);
                    }
                    fileWork.writeLine(stringBuilder.toString());
                }
                case ("3") ->{

                }
                default -> System.out.println("Incorrect command");
            }
        }

    }
}