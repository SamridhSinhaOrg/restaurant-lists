package com.samridh.restaurantlistons.mapper;

import com.samridh.restaurantlistons.dto.RestaurantDTO;
import com.samridh.restaurantlistons.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    RestaurantDTO mapRestaurantToRestaurantDto(Restaurant restaurant);
    Restaurant mapRestaurantDtoToRestaurant(RestaurantDTO restaurantDTO);
}
