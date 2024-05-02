package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Dtos.RestaurantDto;
import com.sst.restaurant_reservation_project.Models.Restaurant;
import com.sst.restaurant_reservation_project.Repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long Id) {
        return restaurantRepository.findById(Id).orElse(null);
    }

    public Restaurant addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDto.getName());
        restaurant.setCity(restaurantDto.getCity());
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long Id, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantRepository.findById(Id).orElse(null);
        if (restaurant == null) {
            restaurant = new Restaurant();
        }
        if(restaurantDto.getName() != null) restaurant.setName(restaurantDto.getName());
        if(restaurantDto.getCity() != null) restaurant.setCity(restaurantDto.getCity());
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long Id) {
        restaurantRepository.deleteById(Id);
    }
}
