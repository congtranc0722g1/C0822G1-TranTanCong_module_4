package com.furama_resort.dto;

import com.furama_resort.model.contract.Contract;
import com.furama_resort.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class CustomerDto implements Validator {
    private int id;
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private String idCard;
    private String phone;
    private String email;
    @NotBlank(message = "Không được để trống")
    private String address;
    private CustomerType customerType;
    private Set<Contract> contracts;

    public CustomerDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (customerDto.name.equals("")){
            errors.rejectValue("name", "name", "Tên không được để trống");
        }else if (!customerDto.name.matches("^([A-Z]+[a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[ ])*([A-Z]+[a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")){
            errors.rejectValue("name", "name", "Tên không đúng định dạng");
        }
        if (customerDto.dateOfBirth.equals("")){
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh không được để trống");
        }
        if (customerDto.idCard.equals("")){
            errors.rejectValue("idCard", "idCard", "Số CMND không được để trống");
        }else if (!customerDto.idCard.matches("^\\d{9,12}$")){
            errors.rejectValue("idCard", "idCard", "Số CMND không đúng định dạng");
        }
        if (customerDto.phone.equals("")){
            errors.rejectValue("phone", "phone", "Số điện thoại không được để trống");
        }else if (!customerDto.phone.matches("^((\\(84\\)\\+)|0)((90)|(91))[\\d]{7}$")){
            errors.rejectValue("phone", "phone", "Số điện thoại không đúng định dạng");
        }
        if (customerDto.email.equals("")){
            errors.rejectValue("email", "email", "Email không được để trống");
        }else if (!customerDto.email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            errors.rejectValue("email", "email", "Email không đúng định dạng");
        }
    }
}
