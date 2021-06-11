package com.unico.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_feira")
public class FeiraLivre {

    @Id
    private Integer id;

    private Integer longitude;

    private Integer lat;

    private String setcens;

    private String areaP;

    private String codDist;

    private String distrito;

    private String codSubPref;
}
