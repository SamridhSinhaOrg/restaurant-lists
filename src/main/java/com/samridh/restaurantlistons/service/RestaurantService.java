package com.samridh.restaurantlistons.service;

import com.samridh.restaurantlistons.Exception.RestaurantNotFoundException;
import com.samridh.restaurantlistons.dto.RestaurantDTO;
import com.samridh.restaurantlistons.entity.Restaurant;
import com.samridh.restaurantlistons.mapper.RestaurantMapper;
import com.samridh.restaurantlistons.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto).toList();
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDto) {
        Restaurant savedRestaurant = restaurantRepository.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
    }

    public RestaurantDTO getRestaurantById(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant does not exist !!"));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant);
    }
}
