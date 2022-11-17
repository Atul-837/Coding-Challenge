package com.coding_challenge.codingchallenge.controller;

import com.coding_challenge.codingchallenge.entity.MediaFile;
import com.coding_challenge.codingchallenge.entity.MediaTopElements;
import com.coding_challenge.codingchallenge.service.MediaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MediaServiceTest {
    private MediaService mediaService;
    private String numOfEl;
    private String id;
    private String imageType;

    @BeforeAll
    public void setUp(){
        mediaService = new MediaService();
        id = "32254";
        imageType = "poster";
    }

    @Test
    void fetchMediaTopElementsTest() {
        numOfEl = "9";
        List<MediaTopElements> mediaTopElements = mediaService.fetchMediaTopElements(numOfEl);
        List<String> collect = mediaTopElements.stream().map(element -> element.getItems().get(0).getName())
                .filter(name -> name.equals("Bosch")).collect(Collectors.toList());
        String result = collect.get(0);
        assertTrue(mediaTopElements.size() > 0, "Api is working and returning results");
        assertNotNull(mediaTopElements.get(0), "Api is working and returning results");
        assertEquals("Bosch", result);
    }

    @Test
    void fetchMediaTopElementsTestMoreThanTen() {
        numOfEl = "12";
        List<MediaTopElements> mediaTopElements = mediaService.fetchMediaTopElements(numOfEl);
        assertEquals( 0, mediaTopElements.size());
    }

    @Test
    void getMediaDetailsTest() {
        MediaFile mediaDetails = mediaService.getMediaDetails(id);
        assertEquals("Bosch", mediaDetails.getName());
        assertEquals("series", mediaDetails.getType());
    }

    @Test
    void getSingleMediaFileTest() {
        MediaFile singleMediaFile = mediaService.getMediaFileWithParams(id, imageType);
        assertEquals(1, singleMediaFile.getImages().size(), "Only one image with poster type");
        assertEquals("poster", singleMediaFile.getImages().get(0).getType());
        assertEquals("Bosch", singleMediaFile.getName());
    }
}