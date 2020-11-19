package openandread;
import java.io.IOException;

public class FileWork {

    Write line = null;
    Read new_file;
    String[] aryStrings;
    String new_path = "D:/log.txt";

    public FileWork(boolean f){
        try {
            line = new Write(new_path, f);
            new_file = new Read(new_path);
            aryStrings = new_file.OpenAndRead();
        }
        catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }


    public void writeLine(String mess) {
        try {
            line.fileWrite(mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFile(){
        for (int i = 0; i < aryStrings.length; i++) {
            System.out.println(aryStrings[i]);
        }
    }

}
