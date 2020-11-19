import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class randGen {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();
        String[] chars = new String[]{"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X", };
        IntStream.range(1, 200).forEach(
                region -> Arrays.stream(chars).forEach(
                        letterA -> Arrays.stream(chars).forEach(
                               letterB -> Arrays.stream(chars).forEach(
                                        letterC -> IntStream.range(1, 10).forEach(
                                                num -> todoList.add(String.format("%s%01d%01d%01d%s%s%03d", letterA, num, num , num, letterB, letterC, region))
                                        )
                               )
                        )
                )
        );

        todoList.forEach(System.out::println);

        HashSet<String> todoHash = new HashSet<>();
        TreeSet<String> todoTree = new TreeSet<>();

        todoHash.addAll(todoList);
        todoTree.addAll(todoList);

        long start;
        long end;

        Scanner sc = new Scanner(System.in);
        String[] s;
        int index;
        boolean check;

        while (true) {
            System.out.println("If you wont search the license plate withe: contains: \"S C A555BC199\"; binarySearch: \"S B A555BC199\"; hashSet: \"S H A555BC199\"; treeSet: \"S T A555BC199\";\n if you wont escape program write\"GG\" ");
            s = sc.nextLine().split("\\s+");
            check = false;
            switch (s[0]) {
                case ("S") -> {
                    if (s.length > 2){
                        if (s[1].equals("C")){
                            start = System.nanoTime();
                            check = todoList.contains(s[2]);
                            end = System.nanoTime();
                            System.out.println(String.format("Indicator: %b; Time: %d\n", check, (end - start)));
                        }
                        else if (s[1].equals("B")){
                            Collections.sort(todoList);
                            start = System.nanoTime();
                            index = Collections.binarySearch(todoList, s[2]);
                            end = System.nanoTime();
                            System.out.println(String.format("Indicator: %d; Time: %d", index, (end - start)));
                        }
                        else if (s[1].equals("H")){
                            start = System.nanoTime();
                            check = todoHash.contains(s[2]);
                            end = System.nanoTime();
                            System.out.println(String.format("Indicator: %b; Time: %d\n", check, (end - start)));
                        }
                        else if (s[1].equals("T")){
                            start = System.nanoTime();
                            check = todoTree.contains(s[2]);
                            end = System.nanoTime();
                            System.out.println(String.format("Indicator: %b; Time: %d\n", check, (end - start)));
                        }
                        else
                            System.out.println("Incorrect input");
                    } else {
                        System.out.println("Incorrect input");
                    }
                }
                case ("GG") -> {
                    return;
                }
                default -> System.out.println("Incorrect command");
            }
        }
    }

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
