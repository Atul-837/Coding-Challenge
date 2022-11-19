import React from "react";
import { GET_MEDIA_FILE_DETAILS_URL } from "../constant_urls/Constant_URLs";

const GetMediaFile = async (id) => {

    const response = await fetch(GET_MEDIA_FILE_DETAILS_URL + id, {
        method: "GET"
    });
    const data = response.json()
    
    console.log("asdjjk")

    return data;

}

export default GetMediaFile;