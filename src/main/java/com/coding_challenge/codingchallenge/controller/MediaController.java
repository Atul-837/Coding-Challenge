package com.coding_challenge.codingchallenge.controller;

import com.coding_challenge.codingchallenge.entity.MediaFile;
import com.coding_challenge.codingchallenge.entity.MediaTopElements;
import com.coding_challenge.codingchallenge.service.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/media")
public class MediaController {

    private final MediaService mediaService;

    // First given API : "https://capi.9c9media.com/destinations/se_atexace/platforms/desktop/medias?$top=5"
    // Created API : "/api/v1/media/topCharts/{any number of elements}"

    @GetMapping("/topCharts/{numOfEl}")
    public List<MediaTopElements> fetchMediaTopElements(@PathVariable String numOfEl){

        return this.mediaService.fetchMediaTopElements(numOfEl);
    }

    // Second given API : "https://capi.9c9media.com/destinations/se_atexace/platforms/desktop/medias/"
    // Created API : "/api/v1/media/{id of particular media object}"
    @GetMapping("/{mediaId}")
    public MediaFile getMediaDetails(@PathVariable String mediaId){

        return this.mediaService.getMediaDetails(mediaId);
    }

    // Created API : "/api/v1/media?id={id of media object}&imageType={type of required image}"
    // Take two parameters i.e. id and image type, and return images of that image type only
    @GetMapping("/specify")
    public MediaFile getMediaFileWithParams(@RequestParam(value = "id") String id,
                                        @RequestParam(value = "imageType") String imageType){
        System.out.println(id + imageType);
        return this.mediaService.getMediaFileWithParams(id, imageType);
    }

}
