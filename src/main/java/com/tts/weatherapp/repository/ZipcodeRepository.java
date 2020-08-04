package com.tts.weatherapp.repository;

import com.tts.weatherapp.model.Zipcode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {
    public Zipcode findByZip(String zipCode);

}