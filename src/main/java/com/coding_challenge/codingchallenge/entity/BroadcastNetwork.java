package com.coding_challenge.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class BroadcastNetwork {

    @JsonProperty("Id")
    private int Id;

    @JsonProperty("BroadcastNetwork")
    private String BroadcastNetwork;


}
