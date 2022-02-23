package com.revature.EmployeeDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class App {
    public static void main (String[] args) throws IDException {
        List<String> lines;
        String data = "src/main/resources/employee.csv";
        App app = new App();

        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(empsFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lines - br.readline();
        for (String empl: lines){
            System.out.println(lines);
        }


    }
}
