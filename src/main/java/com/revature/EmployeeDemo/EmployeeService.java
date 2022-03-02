package com.revature.EmployeeDemo;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) { this.employeeRepository = employeeRepository; }

    public String searchByName(String searchQuery) {
        for (Employee employee : employeeRepository.getEmployees()) {
            if (employee.getName().equalsIgnoreCase(searchQuery))
                return employee.getName();
        }
        return null;
    }

    public void saveEmployee(Employee employee) { employeeRepository.save(employee); }
}
