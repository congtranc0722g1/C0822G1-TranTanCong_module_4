package com.registration_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private int id;
    @Size(min = 5, max = 45, message = "Họ có độ dài tối thiểu là 5 và tối đa 45")
    private String firstname;
    @Size(min = 5, max = 45, message = "Tên có độ dài tối thiểu là 5 và tối đa 45")
    private String lastname ;
    @Pattern(regexp = "[0][0-9]{9}", message = "Số điện thoại phải bắt đầu từ 0 và có 10 số")
    private String phone;
    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    private int age;
    @Pattern(regexp = "[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}", message = "Email chưa đúng định dạng")
    private String email;

    public UserDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
