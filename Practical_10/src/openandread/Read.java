package openandread;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Read {

    private String path_to_file;

    public Read(String path) {
        path_to_file = path;
    }

    public String[] OpenAndRead() throws IOException {

        FileReader x = new FileReader(path_to_file);
        BufferedReader varRead = new BufferedReader(x);

        int num = numStrings();

        String[] lines = new String[num];

        int i;
        for (i = 0; i < num; i++) {
            lines[i] = varRead.readLine();
        }

        varRead.close();
        return lines;
    }

    int numStrings() throws IOException {

        FileReader text = new FileReader(path_to_file);
        BufferedReader y = new BufferedReader(text);

        String one;
        int num = 0;

        while ((one = y.readLine()) != null) {
            num++;
        }
        y.close();

        return num;
    }

}
