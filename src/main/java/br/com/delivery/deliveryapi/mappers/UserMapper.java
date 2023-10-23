package br.com.delivery.deliveryapi.mappers;

import br.com.delivery.deliveryapi.model.DeliveryPerson;
import br.com.delivery.deliveryapi.model.Restaurant;
import br.com.delivery.deliveryapi.model.Users;

import java.util.ArrayList;

public class UserMapper {

    public static Restaurant userToRestaurant(Users user) {
        Restaurant restaurant = new Restaurant();

        restaurant.setId(user.getId());
        restaurant.setAddresses(new ArrayList<>());
        restaurant.setOrders(user.getOrders());
        restaurant.setProducts(new ArrayList<>());
        restaurant.setDocument(user.getDocument());
        restaurant.setName(user.getName());
        restaurant.setEvaluations(new ArrayList<>());
        restaurant.setPassword(user.getPassword());
        restaurant.setProfilePhoto("");
        restaurant.setRole(user.getRole());
        restaurant.setPhoneNumber(user.getPhoneNumber());
        restaurant.setLogin(user.getLogin());

        return restaurant;
    }

    public static DeliveryPerson userToDeliveryPerson(Users user) {
        DeliveryPerson deliveryPerson = new DeliveryPerson();

        deliveryPerson.setId(user.getId());
        deliveryPerson.setOrders(new ArrayList<>());
        deliveryPerson.setName(user.getName());
        deliveryPerson.setDocument(user.getDocument());
        deliveryPerson.setAddresses(new ArrayList<>());
        deliveryPerson.setRating(new ArrayList<>());
        deliveryPerson.setRole(user.getRole());
        deliveryPerson.setLogin(user.getLogin());
        deliveryPerson.setPhoneNumber(user.getPhoneNumber());
        deliveryPerson.setPassword(user.getPassword());

        return deliveryPerson;
    }
}
