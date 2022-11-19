import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Get_Media_File from "./GetMediaFile";
import "../css/MediaFile.css"
import MediaRenderer from "./MediaRenderer";

const MediaFile = () => {

    const {id} = useParams();

    let [mediaFile, setMediaFile] = useState([])

    const fetchData = async () => {
        let file = await Get_Media_File(id)
        setMediaFile(file);
    }

    useEffect(() => {
        fetchData();
    },[])

    return MediaRenderer(mediaFile);

}

export default MediaFile;
