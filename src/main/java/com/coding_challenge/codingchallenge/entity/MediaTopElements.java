package com.coding_challenge.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class MediaTopElements {

    @JsonProperty("Items")
    private List<Item> Items;

    @JsonProperty("ItemsType")
    private String ItemsType;
}
