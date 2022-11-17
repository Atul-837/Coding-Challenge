package com.coding_challenge.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaFile {

    @JsonProperty("Id")
    private int Id;

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("Desc")
    private String Description;

    @JsonProperty("ShortDesc")
    private String ShortDesc;

    @JsonProperty("DFPName")
    private String DFPName;

    @JsonProperty("AgvotCode")
    private String AgvotCode;

    @JsonProperty("AgvotDisclaimer")
    private String AgvotDisclaimer;

    @JsonProperty("QfrCode")
    private String QfrCode;

    @JsonProperty("Type")
    private String Type;

    @JsonProperty("Frequency")
    private String Frequency;

    @JsonProperty("DayPart")
    private String DayPart;

    @JsonProperty("ContainsSeasons")
    private String ContainsSeasons;

    @JsonProperty("InfoUrl")
    private String InfoUrl;

    @JsonProperty("UsualAirTime")
    private String UsualAirTime;

    @JsonProperty("ReleaseYear")
    private String ReleaseYear;

    @JsonProperty("SeasonCount")
    private int SeasonCount;


    @JsonProperty("BroadcastNetworks")
    private List<BroadcastNetwork> BroadcastNetworks;


   @JsonProperty("Keywords")
    private List<Keyword> Keywords;


    @JsonProperty("Tags")
    private List<Tag> Tags;


    @JsonProperty("Images")
    private List<Image> Images;


    @JsonProperty("Genres")
    private List<Genres> Genres;


    @JsonProperty("RatingWarnings")
    private List<RatingWarnings> RatingWarnings;


    @JsonProperty("People")
    private List<People> People;


}
