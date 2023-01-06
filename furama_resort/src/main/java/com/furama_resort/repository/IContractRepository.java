package com.furama_resort.repository;

import com.furama_resort.dto.IContractDto;
import com.furama_resort.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select contract.id, facility.name as facilityName, customer.name as customerName, contract.start_day as startDay, contract.end_day as endDay, contract.deposit as cost, (IFNULL(facility.cost, 0) + sum(IFNULL(contract_detail.quantity, 0) * IFNULL(attach_facility.cost, 0))) AS total \n" +
            "from \n" +
            "  customer\n" +
            " join contract on customer.id = contract.customer_id \n" +
            "  left join facility on facility.id = contract.facility_id \n" +
            "  left join contract_detail on contract_detail.contract_id = contract.id \n" +
            "  left join attach_facility on attach_facility.id = contract_detail.attach_facility_id \n" +
            "group by \n" +
            "  customer.id", nativeQuery = true)
    List<IContractDto> showList();
}
