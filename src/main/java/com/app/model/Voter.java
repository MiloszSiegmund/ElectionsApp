package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Voter {

    @Id
    @GeneratedValue
    private Long id;
    private Integer age;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "constituency_id")
    private Constituency constituency;
}
