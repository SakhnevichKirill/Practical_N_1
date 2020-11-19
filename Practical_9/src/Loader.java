import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Loader {
    public static void main(String[] args) {


        ArrayList<String> todoList = new ArrayList<>();

        todoList.add("Первый");
        todoList.add("Вретье");
        todoList.add("Третье");
        todoList.add("Четвертое");
        todoList.add("Пятое");

        todoList.contains("Пятое");

        Collections.sort(todoList);

        todoList.forEach(System.out::println);

        int index = Collections.binarySearch(todoList, "Пятое");

        if (index > -1)
            System.out.println(todoList.get(index));

        HashSet<String> test = new HashSet<>();
//
//        test.contains(...);
//
//        test.addAll(todoList);
//
//        long start = System.nanoTime();
//
//        ...
//
//        long end = System.nanoTime();
    }
}

/*
A666AA178
B333BB182



X, Y, Z = буква автомобильного номера

N - цифра

R - регион (01 - 199)


 */