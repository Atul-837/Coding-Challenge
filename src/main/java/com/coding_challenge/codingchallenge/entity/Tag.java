package com.coding_challenge.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Tag {


    @JsonProperty("Id")
    private int Id;

    @JsonProperty("Tag")
    private String tag;

}
