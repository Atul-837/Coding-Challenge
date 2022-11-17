package com.coding_challenge.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Item {

    @JsonProperty("Id")
    private int Id;

    @JsonProperty("Name")
    private String Name;
}
