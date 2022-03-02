package com.revature.EmployeeDemo;

public class Main {
    public static void main(String[] args) {
        MainContext.build();

        try{
            MainContext.getTomcat().start();
            MainContext.getTomcat().getServer().await();
        } catch (LifecycleException e) {
            System.err.println("Embedded server failed to start!");
        } //Checking next
    }
}
