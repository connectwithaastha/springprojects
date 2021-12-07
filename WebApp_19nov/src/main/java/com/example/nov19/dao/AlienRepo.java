package com.example.nov19.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.nov19.model.Alien;
@Repository
public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
