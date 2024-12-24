package com.example.employee.controller;
 
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
 
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {
 
@Autowired
private EmployeeService employeeService;
 
// Create a new employee is kavin
@PostMapping
public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
try {
return ResponseEntity.ok(employeeService.createEmployee(employee));
} catch (RuntimeException e) {
return ResponseEntity.badRequest().body(null); // Handle email uniqueness error
}
}
 
// Get all employees is ram
@GetMapping
public List<Employee> getAllEmployees() {
return employeeService.getAllEmployees();
}
 
// Get employee by ID is Manoj
@GetMapping("/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
Optional<Employee> employee = employeeService.getEmployeeById(id);
return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}
 
// Update employee by ID is Ram
@PutMapping("/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails) {
Optional<Employee> updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
return updatedEmployee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}
 
// Delete employee by ID
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
employeeService.deleteEmployee(id);
return ResponseEntity.ok().build();
}
}
