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
public class Candidate {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "constituency_id")
    private Constituency constituency;
}
