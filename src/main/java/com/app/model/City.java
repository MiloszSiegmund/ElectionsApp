package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal population;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "city")
    private Set<Voter> voters = new HashSet<>();

}
