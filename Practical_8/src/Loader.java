import java.util.*;

public class Loader {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();

        todoList.add("Первое дело");
        todoList.add(1, "Второе дело");


        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(todoList.get(i));
        }
        System.out.println();

        for (String item : todoList) {

            System.out.println(item);
        }


        HashSet<String> words = new HashSet<>();

        words.add("Первое");
        words.add("Второе");
        words.add("Третье");
        words.add("Первое");

//        words.contains(); //поиск элемента в массиве

        for (String item : words) {
            System.out.println(item);
        }

        HashMap<String, Integer> good2count = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String goodName = scanner.nextLine();

            if (goodName.equals("List")) {
                printMap(good2count);
                continue;
            }


            int count = 1;

            if (good2count.containsKey(goodName))
                count += good2count.get(goodName);

            good2count.put(goodName, count);
        }
    }

    private static void printMap (Map<String, Integer> map){
        for (String key : map.keySet()) {
            System.out.println(key + "=>" + map.get(key));
        }
    }

}
