package com.coding_challenge.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Keyword {


    @JsonProperty("Id")
    private int Id;

    @JsonProperty("Keyword")
    private String Keyword;

}
