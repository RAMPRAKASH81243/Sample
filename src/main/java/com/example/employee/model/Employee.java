package com.example.employee.model;
 
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 
 @NotBlank(message = "First name is mandatory")
 private String firstName;
 
 @NotBlank(message = "Last name is mandatory")
 private String lastName;
 
 @NotBlank(message = "Age is mandatory")
 @Min(18)
 private Long age;
 
 @NotNull
 @Column(name = "date_of_birth")
 private String dob; // Format: YYYY-MM-DD
 
 @NotNull
 @Pattern(regexp = "^\\d{10}$")
 @Column(unique = true)
 private String mobileNumber;
 
 @NotNull
 private String department;
 
 @Email(message = "Email should be valid")
 @NotNull(message = "Email is mandatory")
 @Column(unique = true)
 private String email;
 
 // Default constructor
 public Employee() {}
 
 // Parameterized constructor
 public Employee(String firstName, String lastName, Long age, String dob, String mobileNumber, String department, String email) {
 this.firstName = firstName;
 this.lastName = lastName;
 this.age = age;
 this.dob = dob;
 this.mobileNumber = mobileNumber;
 this.department = department;
 this.email = email;
 }
 
 
 
// Getters and Setters
 
public Long getId() {
return id;
}
 
public void setId(Long id) {
this.id = id;
}
 
public String getFirstName() {
return firstName;
}
 
public void setFirstName(String firstName) {
this.firstName = firstName;
}
 
public String getLastName() {
return lastName;
}
 
public void setLastName(String lastName) {
this.lastName = lastName;
}
 
public Long getAge() {
return age;
}
 
public void setAge(Long age) {
this.age = age;
}

public String getDob() {
return dob;
}
 
public void setDob(String dob) {
this.dob = dob;
}
 
public String getMobileNumber() {
return mobileNumber;
}
 
public void setMobileNumber(String mobileNumber) {
this.mobileNumber = mobileNumber;
}
 
public String getDepartment() {
return department;
}
 
public void setDepartment(String department) {
this.department = department;
}
 
public String getEmail() {
return email;
}
 
public void setEmail(String email) {
this.email = email;
}
}