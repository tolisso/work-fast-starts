package com.tolisso.bsmicro.dom;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "appuser")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    private Long id;

    @Column(name = "name")
    private String name;
}
