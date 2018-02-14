package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long>{
    List<Room> findRoomByisRented(String isRented);
    List<Room> findRoomById(long id);
    List<Room> findRoomByIsPrivate(Boolean isPrivate);
}