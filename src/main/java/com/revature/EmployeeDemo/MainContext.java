package com.revature.EmployeeDemo;

import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainContext {
    private static final String employeeCSVFile = "employee.csv";
    private static EmployeeRepository employeeRepository;
    private static EmployeeService employeeService;
    private static Tomcat server;
    private static EmployeeController employeeController;
    private static Connection connection;

    public static void build() {
        employeeRepository = new EmployeeRepository(employeeCSVFile);
        employeeService = new EmployeeService(employeeRepository);
        employeeController = new EmployeeController();
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "defaultServlet", new DefaultController()).addMapping("/*");
        server.addServlet("", "employeeServlet", employeeServlet).addMapping("/employees");
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:", "employee", "employee");
            connection.createStatement().execute("CREATE TABLE EMPLOYEES()id int primary key, name varchar");
            employeeRepository.setConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static EmployeeRepository getEmployeeRepository() { return employeeRepository; }
    public static EmployeeService getEmployeeService() { return employeeService; }
    public static Tomcat getTomcat() { return server; }
    }

