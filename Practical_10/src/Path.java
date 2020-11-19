
import java.io.*;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s;
        boolean f = true;

        while (f){
            System.out.println("1 - Enter the path to the folder \"1 ...\"; 2 - Enter the path from \"2 ... ...\"; 3 - escape");
            s = sc.nextLine().split("\\s+");
            switch (s[0]) {
                case ("1") -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 1; i < s.length; i++) {
                        stringBuilder.append(s[i]);
                    }
                    // D:\Java\Practical_N_1\Practical_10\src
                    whenGetReadableSize_thenCorrect(stringBuilder.toString());
                }
                case ("2") -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 2; i < s.length; i++) {
                        stringBuilder.append(s[i]);
                    }
                    File src = new File(s[1]);
                    File dest = new File(stringBuilder.toString());
                    try {
                        copyFolder(src, dest);
                    } catch (IOException e) {
                        System.out.println("File exception");
                    }
                }
                case ("3") -> {
                    f = false;
                    System.out.println("The end.");
                }
                default -> System.out.println("Incorrect command");
            }
        }
    }

    private static void whenGetReadableSize_thenCorrect(String s) {
        File folder = new File(s);
        long size = getFolderSize(folder);

        String[]units = new String[]{ "B", "KB", "MB", "GB", "TB" };
        int unitIndex = (int) (Math.log10(size)/3);
        double unitValue = 1 << (unitIndex *  10);

        String readableSize = new DecimalFormat("#,##0.#")
                .format(size/unitValue) + " "
                + units[unitIndex];
        System.out.println("Размер папки " + s + " составляет " + readableSize);
    }

    public static void copyFolder(File src, File dest) throws IOException{

        if(src.isDirectory()){

            //if directory not exists, create it
            if(!dest.exists()){
                dest.mkdir();
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }

            //list all the directory contents
            String files[]= src.list();

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile,destFile);
            }

        }else{
            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[]buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }


    private static long getFolderSize(File folder) {
        long length = 0;
        File[]files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
            else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
}