package com.sst.restaurant_reservation_project.Controllers;

import com.sst.restaurant_reservation_project.Dtos.RestaurantDto;
import com.sst.restaurant_reservation_project.Models.Restaurant;
import com.sst.restaurant_reservation_project.Services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;
    RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("{Id}")
    public Restaurant getRestaurantById(@PathVariable Long Id) {
        return restaurantService.getRestaurantById(Id);
    }

    @PostMapping("")
    public Restaurant addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.addRestaurant(restaurantDto);
    }

    @PatchMapping("{Id}")
    public Restaurant updataRestaurant(@PathVariable Long Id, @RequestBody RestaurantDto restaurantDto) {
        return restaurantService.updateRestaurant(Id, restaurantDto);
    }

    @DeleteMapping("{Id}")
    public void deleteRestaurant(@PathVariable Long Id) {
        restaurantService.deleteRestaurant(Id);
    }


}
