package com.furama_resort.model.customer;

import com.furama_resort.model.contract.Contract;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(45)")
    private String name;

    @Column(columnDefinition = "date")
    private LocalDate dateOfBirth;

    private boolean gender;

    @Column(columnDefinition = "varchar(45)")
    private String idCard;

    @Column(columnDefinition = "varchar(45)")
    private String phone;

    @Column(columnDefinition = "varchar(45)")
    private String email;

    @Column(columnDefinition = "varchar(45)")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false, referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public Customer() {

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
}
