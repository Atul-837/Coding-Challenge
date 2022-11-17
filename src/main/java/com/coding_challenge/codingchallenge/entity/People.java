package com.coding_challenge.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {

    @JsonProperty("Id")
    private int Id;

    @JsonProperty("RoleName")
    private String RoleName;

    @JsonProperty("FirstName")
    private String FirstName;

    @JsonProperty("LastName")
    private String LastName;

    @JsonProperty("Alias")
    private String Alias;

    @JsonProperty("Images")
    private List<Image> Images;

}
