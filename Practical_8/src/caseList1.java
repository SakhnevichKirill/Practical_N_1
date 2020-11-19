import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class caseList1 {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String order;
        int f;
        int r;
        int k = 0;
        String name = "";
        boolean flag = false;

        while (!flag) {
            order = sc.nextLine();
            f = order.indexOf(' ');
            if (f != -1){
                name = order.substring(0, f);
                if (name.equals("ADD")){
                    r = order.indexOf(' ', f+1 );
                    if (r == -1){
                        name = order.substring(f+1, order.length()); // без ключа
                        todoList.add(name);
                    }
                    else if (tryCatch(order.substring(f+1, r))){ // по ключу
                        k = Integer.parseInt(order.substring(f+1, r));
                        name = order.substring(r+1, order.length());
                        if (todoList.size() >= k){
                            todoList.add(k, name);
                        }
                        else {
                            todoList.add(name);
                        }
                    }
                }
                else if (name.equals("EDIT")){
                    r = order.indexOf(' ');
                    if (r == -1){
                        System.out.println("Неправильный ввод ключа! Попробуйте еще раз.");
                        f = 0;
                        k = 0;
                        name = "";
                    }
                    else if (tryCatch(order.substring(f+1, r))){ // изменить по ключу
                        k = Integer.parseInt(order.substring(f+1, r));
                        name = order.substring(r+1, order.length());
                        todoList.add(k, name);
                    }
                    else {
                        System.out.println("Неправильный ввод ключа! Попробуйте еще раз.");
                        f = 0;
                        k = 0;
                        name = "";
                    }
                }
                else if (name.equals("DELETE")){
                    if (tryCatch(order.substring(f+1, order.length()))){ //удалить по ключу
                        k = Integer.parseInt(order.substring(f+1, order.length()));
                        todoList.remove(k);
                    }
                    else { // удалить всё
                        todoList.clear();
                    }
                }
            }
            else{
                if (order.equals("LIST")){
                    printList(todoList);
                }
                else{
                    System.out.println("Такой команды не существует ");
                }
            }
        }
    }


    private static void printList (ArrayList<String> todoList){
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i+1 + " - " + todoList.get(i));
        }
    }

    public static boolean tryCatch(String name) {
        try {
            Integer.parseInt(name);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

