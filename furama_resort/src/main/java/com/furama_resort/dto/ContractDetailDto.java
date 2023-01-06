package com.furama_resort.dto;


public class ContractDetailDto {
    private int id;
    private int quantity;
    private Integer contract;
    private Integer attachFacility;

    public ContractDetailDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getContract() {
        return contract;
    }

    public void setContract(Integer contract) {
        this.contract = contract;
    }

    public Integer getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(Integer attachFacility) {
        this.attachFacility = attachFacility;
    }
}
