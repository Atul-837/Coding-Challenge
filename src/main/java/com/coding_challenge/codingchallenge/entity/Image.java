package com.coding_challenge.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @JsonProperty("Url")
    private URL Url;

    @JsonProperty("Type")
    private String Type;

    @JsonProperty("Width")
    private int Width;

    @JsonProperty("Height")
    private int Height;

}
