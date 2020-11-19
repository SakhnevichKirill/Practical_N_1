import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class caseList {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> todoList = new HashMap<>();
        String order;
        String number;
        int f;
        int r;
        int k = 0;
        String name = "";
        boolean flag = false;


        while (!flag){
            order = sc.nextLine();
            f = order.indexOf(' ');
            if (f != -1){
//                name = order.substring(0, f);
//                if (name.equals("ADD")){
//                    r = order.indexOf(' ', f+1 );
//                    if (r == -1){
//                        name = order.substring(f+1, order.length()); // без ключа
//                        k = getKey(name);
//                        todoList.put(k, name);
//                    }
//                    else if (tryCatch(order.substring(f+1, r))){ // по ключу
//                        k = order.charAt(f+2);
//                        name = order.substring(r+1, order.length());
//                        todoList.put(k, name);
//                    }
//                }
//                else if (name.equals("EDIT")){
//                    r = order.indexOf(' ');
//                    if (tryCatch(order.substring(f+1, r))){ // изменить по ключу
//                        k = order.charAt(f+1);
//                        name = order.substring(r+1, order.length());
//                        todoList.put(k, name);
//                    }
//                    else {
//                        System.out.println("Неправильный ввод ключа! Попробуйте еще раз.");
//                        f = 0;
//                        k = 0;
//                        name = "";
//                    }
//                }
//                else if (name.equals("DELETE")){
//                    if (tryCatch(order.substring(f+1, order.length()))){ //удалить по ключу
//                        k = order.charAt(f+1);
//                        todoList.remove(k);
//                    }
//                    else { // удалить всё
//                        todoList.clear();
//                    }
//                }
            }
            else{
                number = order.replaceAll("[^0-9]", "");
                if (order.equals("LIST")){
                    printMap(todoList);
                }
                else if (number.length() > 2){ //если введено число
                    number = genNumber(number); // приводим номер к нормальному виду
                    if (todoList.containsValue(number)){ // если такой номер есть
                        System.out.println("Такой контакт уже существует:");
                        printNode(todoList, number);
                    }
                    else {
                        System.out.println("Введите имя соответствующее номеру: ");
                        order = sc.nextLine();
                        todoList.put(order, number);
                    }
                }
                else { // если введено слово
                    if (todoList.containsKey(order)){ // если такое слово есть
                        System.out.println("Такой контакт уже существует:");
                        printNode(todoList, order);
                    }
                    else if (order.length() > 2){
                        System.out.println("Введите контактный номер телефона: ");

                        number = genNumber(number = sc.nextLine());
                        todoList.put(order, number);
                    }
                    else {
                        System.out.println("Попробуйте снова");
                    }
                }
            }
        }
    }


    private static String genNumber(String number) {
        StringBuffer numberF = new StringBuffer();

        Scanner sc = new Scanner(System.in);

        boolean f = false;

        while (!f) {
            number = number.replaceAll("[^0-9]", "");
            if (number.length() == 11 || number.length() == 10) {
                if (number.charAt(0) == '7' && number.length() == 11) {
                    numberF.append(number);
                    numberF.insert(0, "+");
                    numberF.insert(2, " (");
                    numberF.insert(7, ") ");
                    numberF.insert(12, "-");
                    numberF.insert(15, "-");
                    f = true;
                    System.out.println(numberF);
                    return numberF.toString();
                } else if (number.charAt(0) == '8' && number.length() == 11) {
                    numberF.append(number);
                    numberF.delete(0, 1);
                    numberF.insert(0, "+7");
                    numberF.insert(2, " (");
                    numberF.insert(7, ") ");
                    numberF.insert(12, "-");
                    numberF.insert(15, "-");
                    f = true;
                    System.out.println(numberF);
                    return numberF.toString();
                } else if (number.charAt(0) != '7' && number.length() == 10) {
                    numberF.append(number);
                    numberF.insert(0, "+7");
                    numberF.insert(2, " (");
                    numberF.insert(7, ") ");
                    numberF.insert(12, "-");
                    numberF.insert(15, "-");
                    f = true;
                    System.out.println(numberF);
                    return numberF.toString();
                } else {
                    System.out.println("Неверный ввод.");
                    System.out.println("Попробуйте еще раз:");
                    number = sc.next();
                    numberF.append(number);
                    numberF.delete(0, numberF.length());
                }
            } else {
                System.out.println("Неверный ввод.");
                System.out.println("Попробуйте еще раз:");
                number = sc.next();
                numberF.delete(0, numberF.length());
            }
        }
        return "F";
    }

    private static int getKey(String order){
        int k = 0;
        for (int i = 0; i < order.length(); i++){
            k += (int)order.charAt(i);
        }
        return k;
    }

    private static void printNode(Map<String, String> map, String a){
        for (String key : map.keySet()) {
            if (map.get(key).equals(a)){
                System.out.println(key + " => " + map.get(key));
            }
            else if(key.equals(a)){
                System.out.println(key + " => " + map.get(key));
                break;
            }
        }
    }

    private static void printMap (Map<String, String> map){
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, String>comparingByKey())
                .forEach(System.out::println);
//        for (String key : map.keySet()) {
//            System.out.println(key + " => " + map.get(key));
//        }
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
