import openandread.FileWork;

import java.io.IOException;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s;
        boolean f = true;
        FileWork fileWork = new FileWork(f);
        fileWork.setMap();

        while (f){
            System.out.println("1 - print; 2 - exit");
            s = sc.nextLine().split("\\s+");
            switch (s[0]) {
                case ("1") -> {
                    fileWork.printMap();
                }
                case ("2") ->{
                    return;
                }
                default -> System.out.println("Incorrect command");
            }
        }

    }
}