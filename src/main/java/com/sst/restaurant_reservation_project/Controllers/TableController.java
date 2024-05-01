package com.sst.restaurant_reservation_project.Controllers;

import com.sst.restaurant_reservation_project.Dtos.R_Table_dto;
import com.sst.restaurant_reservation_project.Models.Customer;
import com.sst.restaurant_reservation_project.Models.Location;
import com.sst.restaurant_reservation_project.Models.R_Table;
import com.sst.restaurant_reservation_project.Models.State;
import com.sst.restaurant_reservation_project.Services.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sst.restaurant_reservation_project.Models.Location.*;

@RestController
@RequestMapping("/table")
public class TableController {
    TableService tableService ;
    TableController(TableService tableService){
        this.tableService = tableService;
    }

    @GetMapping("")
    public List<R_Table> fetchAllCustomers() {
        return tableService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public R_Table getTableById(@PathVariable Long id){
        return tableService.getTableById(id);
    }

    @PostMapping("")
    public ResponseEntity<R_Table> createCustomer(@RequestBody R_Table_dto table) {
        R_Table newTable = new R_Table();
        newTable.setCapacity(table.getCapacity());
     //   newTable.setReservations(table.getReservations());
        newTable.setLocation(Location.WINDOWSIDED);
        if(table.getLocation().equals("PRIVATECABIN")) newTable.setLocation(PRIVATECABIN);
        if(table.getLocation().equals("GENERAL")) newTable.setLocation(GENERAL);
        newTable.setState(State.AVAILABLE);
       // if(table.getState().equals("OCCUPIED")) newTable.setState(State.OCCUPIED);
        R_Table createdTable = tableService.createTable(newTable);
        return new ResponseEntity<>(createdTable, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        tableService.deleteTable(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<R_Table> updateCustomer(@PathVariable Long id, @RequestBody R_Table_dto table) {
        R_Table tableToUpdate = new R_Table();
        tableToUpdate.setId(id);
        tableToUpdate.setState(State.AVAILABLE);
        tableToUpdate.setCapacity(table.getCapacity());
        tableToUpdate.setLocation(Location.WINDOWSIDED);
        if(table.getLocation().equals("PRIVATECABIN")) tableToUpdate.setLocation(PRIVATECABIN);
        if(table.getLocation().equals("GENERAL")) tableToUpdate.setLocation(GENERAL);
        R_Table updatedTable = tableService.updateTable(tableToUpdate);
        if (updatedTable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTable, HttpStatus.OK);
    }
}
