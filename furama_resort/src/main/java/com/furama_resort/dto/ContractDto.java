package com.furama_resort.dto;

import com.furama_resort.model.contract.ContractDetail;
import com.furama_resort.model.customer.Customer;
import com.furama_resort.model.employee.Employee;
import com.furama_resort.model.facility.Facility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ContractDto {
    private int id;
    private LocalDate startDay;
    private LocalDate endDay;
    private double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private Set<ContractDetail> contractDetails;

    public ContractDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(startDay, dateFormat);
        this.startDay = date;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(endDay, dateFormat);
        this.endDay = date;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
