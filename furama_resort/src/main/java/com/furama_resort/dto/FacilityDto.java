package com.furama_resort.dto;

import com.furama_resort.model.contract.Contract;
import com.furama_resort.model.facility.Facility;
import com.furama_resort.model.facility.FacilityType;
import com.furama_resort.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class FacilityDto implements Validator {
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    @NotBlank(message = "Không được để trống")
    private String standardRoom;
    @NotBlank(message = "Không được để trống")
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numbersOfFloors;
    @NotBlank(message = "Không được để trống")
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;
    private Set<Contract> contracts;

    public FacilityDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumbersOfFloors() {
        return numbersOfFloors;
    }

    public void setNumbersOfFloors(Integer numbersOfFloors) {
        this.numbersOfFloors = numbersOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
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
        FacilityDto facilityDto = (FacilityDto) target;
        if (facilityDto.name.equals("")){
            errors.rejectValue("name", "name", "Không được để trống");
        }else if (!facilityDto.name.matches("([A-Z]+[a-z 0-9]*[ ]*)*")){
            errors.rejectValue("name", "name", "Tên không đúng định dạng");
        }

        if (facilityDto.facilityType.getId() == 3){
            facilityDto.setNumbersOfFloors(null);
        }else if (!(String.valueOf(facilityDto.numbersOfFloors).matches("^\\d+$"))){
            errors.rejectValue("numbersOfFloors", "numbersOfFloors", " Số tầng phải là số nguyên dương");
        }else if (facilityDto.numbersOfFloors <= 0){
            errors.rejectValue("numbersOfFloors", "numbersOfFloors", "Số tầng phải lớn hơn 0");
        }

        if (facilityDto.facilityType.getId() == 2 || facilityDto.facilityType.getId() == 3){
            facilityDto.setPoolArea(null);
        }

        if (facilityDto.facilityType.getId() == 1 || facilityDto.facilityType.getId() == 2){
            facilityDto.setFacilityFree(null);
        }
    }
}
