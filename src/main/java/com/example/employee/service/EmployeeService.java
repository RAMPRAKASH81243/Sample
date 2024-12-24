package com.example.employee.service;
 
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
 
@Autowired
private EmployeeRepository employeeRepository;
 
// Create employee (ensure email uniqueness)
public Employee createEmployee(Employee employee) {
if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
throw new RuntimeException("Employee with this email already exists");
}
return employeeRepository.save(employee);
}
 
// Get employee by ID
public Optional<Employee> getEmployeeById(Long id) {
return employeeRepository.findById(id);
}
 
// Get all employees
public List<Employee> getAllEmployees() {
return employeeRepository.findAll();
}
 
// Update employee by ID
public Optional<Employee> updateEmployee(Long id, Employee employeeDetails) {
return employeeRepository.findById(id).map(employee -> {
if (!employee.getEmail().equals(employeeDetails.getEmail()) && employeeRepository.findByEmail(employeeDetails.getEmail()).isPresent()) {
throw new RuntimeException("Email already exists");
}
employee.setFirstName(employeeDetails.getFirstName());
employee.setLastName(employeeDetails.getLastName());
employee.setAge(employeeDetails.getAge());
employee.setDob(employeeDetails.getDob());
employee.setMobileNumber(employeeDetails.getMobileNumber());
employee.setDepartment(employeeDetails.getDepartment());
employee.setEmail(employeeDetails.getEmail());
return employeeRepository.save(employee);
});
}
 
// Delete employee by ID
public void deleteEmployee(Long id) {
employeeRepository.deleteById(id);
}
}