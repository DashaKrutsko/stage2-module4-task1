package com.mjc.stage2;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Employee {
    private String name;
    private String lastName;
    private String position;
    private String phone;
    private String email;
    private String carNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    private Employee (EmployeeBuilder employeeBuilder){
        this.name = employeeBuilder.name;
        this.lastName = employeeBuilder.lastName;
        this.position = employeeBuilder.position;
        this.phone = employeeBuilder.phone;
        this.email = employeeBuilder.email;
        this.carNumber = employeeBuilder.carNumber;
    }

    public static class EmployeeBuilder {
        private String name;
        private String lastName;
        private String position;
        private String phone;
        private String email;
        private String carNumber;

        public EmployeeBuilder() {

        }

        public EmployeeBuilder setName(String nameBuilder){
            name = nameBuilder;
            return this;
        }

        public EmployeeBuilder setLastName(String lastNameBuilder){
            lastName = lastNameBuilder;
            return this;
        }

        public EmployeeBuilder setPosition(String positionBuilder){
            position = positionBuilder;
            return this;
        }

        public EmployeeBuilder setPhone(String phoneBuilder){
            phone = phoneBuilder;
            return this;
        }

        public EmployeeBuilder setEmail(String emailBuilder){
            email = emailBuilder;
            return this;
        }

        public EmployeeBuilder setCarNumber(String carNumberBuilder){
            carNumber = carNumberBuilder;
            return this;
        }

        private Employee buildEmployee(){
            return new Employee(this);
        }
    }

}
