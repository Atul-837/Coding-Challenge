import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { GET_MEDIA_BY_PARAMS_URL } from "../constant_urls/Constant_URLs";
import MediaRenderer from "./MediaRenderer";

const MediaFileWithParams = () => {
    
    let [file, setFile] = useState([])
    const {mediaId, imageType} = useParams();
    console.log(mediaId + " " + imageType)

    const fetchData = async () => {
        const response = await fetch(GET_MEDIA_BY_PARAMS_URL + `?id=${mediaId}&imageType=${imageType}`, {
            method: "GET"
        });
        const data = await response.json();

        setFile(data)
    }

    useEffect(() => {
        fetchData()
    },[])
    
    return MediaRenderer(file)

}

export default MediaFileWithParams;