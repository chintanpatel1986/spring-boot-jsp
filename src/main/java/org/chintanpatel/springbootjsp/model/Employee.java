package org.chintanpatel.springbootjsp.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tbl_employee_employee_id_seq')")
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Size(max = 255)
    @NotEmpty(message = "Please Enter FirstName")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 255)
    @NotEmpty(message = "Please Enter MiddleName")
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Size(max = 255)
    @NotEmpty(message = "Please Enter LastName")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Size(max = 255)
    @NotEmpty(message = "Please Select Gender")
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotEmpty(message = "Please Select Programming Language")
    @Column(name = "programming_language", columnDefinition = "varchar [](255) not null")
    private String[] programmingLanguage;

    @Size(max = 255)
    @NotEmpty(message = "Please Enter Email")
    @Email(message = "Please Enter Valid Email")
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotEmpty(message = "Please Enter Mobile Number")
    @Column(name = "mobile", nullable = false)
    private String mobile;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please Enter BirthDate")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Size(max = 255)
    @NotEmpty(message = "Please Enter UserName")
    @Column(name = "user_name", nullable = false)
    private String userName;

    @Size(min = 8, max = 15, message = "Password Must Be Between 8 And 15 Character")
    @NotEmpty(message = "Please Enter Password")
    @Column(name = "password", nullable = false, length = 15)
    private String password;

    @Valid
    @NotNull(message = "Please Enter Department")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('tbl_employee_department_id_seq')")
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Valid
    @NotNull(message = "Please Enter Role")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('tbl_employee_role_id_seq')")
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String[] programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}