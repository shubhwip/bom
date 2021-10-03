package com.bom.materials.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@ToString
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customerId;

    @NotNull
    private String companyName;

    @NotNull
    private String email;

    @NotNull
    private String maintainer;

    @NotNull
    private String versionControlUrl;

}
