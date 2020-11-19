import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class caseTreeSet {
// kitill.sakh@gmail.com
// Kirill.sakh@mail.ru
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        TreeSet<String> mailAddress = new TreeSet<>();
        
        String[] s;
        
        while (true) {
            s = sc.nextLine().split("\\s+");
            switch (s[0]) {
                case ("ADD") -> {
                    if (s.length > 1) {
                        if (isMailCorrect(s[1])) {
                            mailAddress.add(s[1]);
                        }
                        System.out.println("Incorrect input");
                    } else {
                        System.out.println("Incorrect input");
                    }
                    break;
                }
                case ("LIST") -> {
                    printList(mailAddress);
                    break;
                }
                default -> System.out.println("Incorrect command");
            }
        }

    }
    
    static boolean isMailCorrect(String s) {
        return Pattern.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}", s);
    }
    
    private static void printList (TreeSet<String> todoList){
        for (String s : todoList) {
            System.out.println(s);
        }
    }

}
