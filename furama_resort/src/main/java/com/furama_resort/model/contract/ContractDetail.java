package com.furama_resort.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false, referencedColumnName = "id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_facility_id", nullable = false, referencedColumnName = "id")
    private AttachFacility attachFacility;
}
