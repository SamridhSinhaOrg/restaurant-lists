package com.samridh.restaurantlistons.controller;

import com.samridh.restaurantlistons.dto.RestaurantDTO;
import com.samridh.restaurantlistons.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> restaurantList = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurantList);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addANewRestaurant(@RequestBody RestaurantDTO restaurantDto) {
        RestaurantDTO restaurantDTO = restaurantService.addRestaurantInDB(restaurantDto);
        return new ResponseEntity<>(restaurantDTO, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantById/{id}")
    public ResponseEntity<RestaurantDTO> getAllRestaurants(@PathVariable Integer id) {
        RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(id);
        return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);

    }


}
