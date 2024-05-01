package com.sst.restaurant_reservation_project.Repositories;

import com.sst.restaurant_reservation_project.Models.Customer;
import com.sst.restaurant_reservation_project.Models.R_Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<R_Table, Long> {
    @Override
    R_Table save(R_Table table);
}
