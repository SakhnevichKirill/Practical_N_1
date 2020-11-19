package openandread;
import Company.Company;

import java.io.IOException;
import java.util.List;

public class FileWork {

    Write fileWrite = null;
    Read fileRead;
    String[] aryStrings;
    List<Company> arrayList;
    final String new_path = "D:\\Java\\Practical_N_1\\Practical_11\\movementList.csv";

    public FileWork(boolean f){
        try {
            fileWrite = new Write(new_path, f);
            fileRead = new Read(new_path);
            aryStrings = fileRead.OpenAndRead();
        }
        catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }


    public void compareToCompany(){
        String[] s;
        Company company;
        for (String line: aryStrings) {
            s = line.split("\\s+");
            for (int i = 1; i < s.length; i++){
                s[i].split("\\s+");
                company.setCompany();
            }
            arrayList.add()
        }

    }


    public void writeLine(String mess) {
        try {
            fileWrite.fileWrite(mess);
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
