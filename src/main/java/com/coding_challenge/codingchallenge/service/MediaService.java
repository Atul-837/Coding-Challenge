package com.coding_challenge.codingchallenge.service;

import com.coding_challenge.codingchallenge.entity.Image;
import com.coding_challenge.codingchallenge.entity.MediaFile;
import com.coding_challenge.codingchallenge.entity.MediaTopElements;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.coding_challenge.codingchallenge.constants.Constants.GET_MEDIA_DETAILS;
import static com.coding_challenge.codingchallenge.constants.Constants.GET_MEDIA_LIST;

@Service
@AllArgsConstructor
@Data
public class MediaService {

    // Client side HTTP request will be handled and interact with server through API
    // API Integration
    private final WebClient webClient = WebClient.create();

    //Method to fetch the number of items list specified by user from 1-10
    public List<MediaTopElements> fetchMediaTopElements(String number){
        List<MediaTopElements> result = new ArrayList<>();
        int num = Integer.parseInt(number);

        // Check whether request lies between 1-10 as per requirement for first API
        if(num >= 1 && num <= 10) {

            // Building the specific url to talk to server side application
            String uri = UriComponentsBuilder.fromUriString(GET_MEDIA_LIST).queryParam("$top", number)
                    .build().toUriString();

            result = webClient.get().uri(uri)
                    .retrieve()
                    .bodyToFlux(MediaTopElements.class)
                    .collectList()
                    .block();
        }
        return result;
    }

    // Method for fetching full information about a media file like id, name, images, genres etc.
    public MediaFile getMediaDetails(String mediaId){

        // Building the specific url to talk to server side application
        String uri = UriComponentsBuilder.fromUriString(GET_MEDIA_DETAILS).path(mediaId)
                .build().toUriString();


        return webClient.get().uri(uri)
                .retrieve()
                .bodyToMono(MediaFile.class)
                .block();
    }

    // Method takes two parameters i.e. id and image type which in return provide media info with
    // requested image type only
    public MediaFile getMediaFileWithParams(String id, String imageType){

        // Building the specific url to talk to server side application
        String uri = UriComponentsBuilder.fromUriString(GET_MEDIA_DETAILS)
                .path(id)
                .build().toUriString();

        MediaFile selectedFile = webClient.get().uri(uri)
                .retrieve()
                .bodyToMono(MediaFile.class)
                .block();

        // since user will use the id from list available so assuming above request will return media file
        //with particular id, then we can apply the second param and filter the images with required image type
        assert selectedFile != null;
        List<Image> imageList = selectedFile.getImages().stream()
                .filter(image -> image.getType().equals(imageType))
                .collect(Collectors.toList());
        selectedFile.setImages(imageList);
        System.out.println(selectedFile);
        return selectedFile;
    }
}
