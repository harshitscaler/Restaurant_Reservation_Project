package com.sst.restaurant_reservation_project.Repositories;

import com.sst.restaurant_reservation_project.Models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
}
