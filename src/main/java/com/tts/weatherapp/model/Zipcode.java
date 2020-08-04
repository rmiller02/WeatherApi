package com.tts.weatherapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Zipcode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NonNull
    private Long id;

    @NonNull
    @Column(unique = true)
    private String zip;

    public Zipcode(String zip) {
        this.zip = zip;
    }

}