import React from "react";
import { GET_MEDIA_LIST_URL } from "../constant_urls/Constant_URLs";

const Get_List = async (number) => {

    const response = await fetch(GET_MEDIA_LIST_URL + number,{
        method: "GET"
    });
    const data = await response.json();

    return data;
}

export default Get_List;