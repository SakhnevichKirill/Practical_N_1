package openandread;
import Company.Company;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileWork {

    Write fileWrite = null;
    Read fileRead;
    String[] aryStrings;

    HashMap<String, Company> map = new HashMap<>();;

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

    public void setMap(){
        String[] s;
        Company company = null;
        for (String line: aryStrings) {
            compareToCompany(line);
        }
    }

    public void compareToCompany(String line){
        Company company = new Company();
        String[] column = line.split(",");
        String describe = null;

        if (column[5].contains("\\"))
            describe = column[5].substring(column[5].lastIndexOf("\\") + 1, column[5].indexOf("          "));
        else if (column[5].contains("/"))
            describe = column[5].substring(column[5].lastIndexOf("/") + 1, column[5].indexOf("          "));

        column[6] = column[6].replaceAll("\\D", "");
        column[7] = column[7].replaceAll("\\D", "");

        System.out.println("Приход = " + column[6] + " , расход = " + column[7] + "\nОписание - " + describe + "\n");



        if (column[6].matches("\\d+") && column[7].matches("\\d+")) {
            int income = Integer.parseInt(column[6]);
            int expense = Integer.parseInt(column[7]);
            if (income > 0) {
                if (map.containsKey(describe)) {
                    map.get(describe).addIncome(income);
                }
                else {
                    company.setCompany(describe);
                    company.addIncome(income);
                    map.put(describe, company);
                }
            } else {
                if (map.containsKey(describe)) {
                    map.get(describe).addExpenses(expense);
                }
                else {
                    company.setCompany(describe);
                    company.addExpenses(expense);
                    map.put(describe, company);
                }
            }
        }
    }

    public void printMap(){
        for(Map.Entry<String, Company> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
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
