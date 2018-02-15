package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long>{
    List<Room> findRoomByRented(Boolean Rented);
    List<Room> findRoomById(long id);
    List<Room> findRoomByPrivte(Boolean Privte);
}