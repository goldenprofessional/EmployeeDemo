package com.revature.EmployeeDemo;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.util.List;

public class App {
    public static void main (String[] args) throws Exception {

        try(ServerSocket serverSocket = new ServerSocket(8080)){
            System.out.println("Server started. \n Listening for messages.");

            while(true) {

                try(Socket client = serverSocket.accept()) {

                    System.out.println("Debug: got new message " + client.toString());

                    InputStreamReader isr = new InputStreamReader(client.getInputStream());

                    BufferedReader br = new BufferedReader(isr);

                    StringBuilder request = new StringBuilder();

                    String line; // what is our temporary variable called line. this holds one line of our message
                    line = br.readLine();
                    while(!line.isBlank()) {
                        request.append(line + "\r\n");
                        line = br.readLine();
                    }

                    System.out.println("--THE REQUEST");
                    System.out.println(request);


                }

            }
        }
//        List<String> lines;
//        String data = "src/main/resources/employee.csv";
//        App app = new App();
//
//        BufferedReader br = null;
//        try{
//            br = new BufferedReader(new FileReader(empsFileName));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        lines - br.readline();
//        for (String empl: lines){
//            System.out.println(lines);
        }


    }
