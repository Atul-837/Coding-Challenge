import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Get_List from "./GetList";
import GetMediaFile from "./GetMediaFile";
import "../css/MediaList.css"

const MediaList = () => {

    let [list, setList] = useState([]);
    const {number} = useParams();

    const fetchData = async () => {
        let listArr = []
        let data = await Get_List(number);
    
        for(let i = 0; i < data.length; i ++){
            let items = data[i].Items;
            for(let j = 0; j < items.length; j++){
                let temp = {}
                let result = await GetMediaFile(items[j].Id)
                temp.Id = result.Id
                temp.Name = result.Name
                if(result.Images.length !== 0){
                for(let k = 0; k < result.Images.length; k++){
                    let image = result.Images[0];
                    if(image.Type === "poster"){
                        temp.Image = image.Url
                        break;
                     }
                    else if(image.Type === "thumbnail") {
                    temp.Image = image.Url
                     break;
                    }
                    else 
                    temp.Image = "/npa.png"
                    }
                }
                     
                   else temp.Image = "/npa.png"
                    listArr.push(temp)

                    }
                }
                  setList(listArr)  
            }

    useEffect(() => {
        fetchData()
    },[])
    
    console.log(list)

    return list.length !== 0 ?
             <div className="container-fluid media-list">
             {
                list.map(file => 
                    <div className="card" key={file.Id}> 
                    <a className="linker" href={`/media/${number}/id/${file.Id}`}><div className="card-body">
                        <img src={`${file.Image}`} className="card-img-top" alt="..."/>  
                        
                        <ul className="list-group list-group-flush">
                            <h4 className="text">{file.Name}</h4>
                            <h5 className="text">Id: {file.Id}</h5>
                        </ul>  
                        </div> </a> 
                    </div>
                )
                
            }
           </div> : <div className=" container-fluid error">
                <div className="container fluid err">
                <div >WE ARE UNABLE TO SERVE CONTENT MORE THAN 10 AT THIS MOMENT<br/> PLEASE ENTER NUMBER FROM 1 - 10 </div><br/>
                <a href="/" type="btn" className="back btn btn-danger" >👈 GO BACK</a>
                </div>
            </div>
}

export default MediaList;