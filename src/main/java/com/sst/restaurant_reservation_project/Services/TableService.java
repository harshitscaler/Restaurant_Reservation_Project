package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Models.Customer;
import com.sst.restaurant_reservation_project.Models.R_Table;
import com.sst.restaurant_reservation_project.Models.Reservation;
import com.sst.restaurant_reservation_project.Repositories.CustomerRepository;
import com.sst.restaurant_reservation_project.Repositories.ReservationsRepository;
import com.sst.restaurant_reservation_project.Repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    private final TableRepository tableRepository;
    private final ReservationsRepository reservationsRepository;

    public TableService(TableRepository tableRepository, ReservationsRepository reservationsRepository) {

        this.tableRepository = tableRepository;
        this.reservationsRepository = reservationsRepository;
    }

    public List<R_Table> getAllTables() {
        Iterable<R_Table> table =  tableRepository.findAll();
        List<R_Table> tableList = new ArrayList<>();
        table.forEach(tableList::add);
        return tableList;
    }
    public R_Table getTableById(Long id) {

        return tableRepository.findById(id).orElse(null);

    }

    public R_Table createTable(R_Table table) {
        return tableRepository.save(table);
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }

    public R_Table updateTable(R_Table table) {

        return tableRepository.save(table);
    }

    public List<Reservation> getReservations(Long id) {

        return reservationsRepository.findReservationByTableId(id);
    }


}
