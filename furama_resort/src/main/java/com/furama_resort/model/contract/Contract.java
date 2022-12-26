package com.furama_resort.model.contract;

import com.furama_resort.model.customer.Customer;
import com.furama_resort.model.employee.Employee;
import com.furama_resort.model.facility.Facility;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "date")
    private LocalDate startDay;

    @Column(columnDefinition = "date")
    private LocalDate endDay;

    private double deposit;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false, referencedColumnName = "id")
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

    public Contract() {

    }
}
