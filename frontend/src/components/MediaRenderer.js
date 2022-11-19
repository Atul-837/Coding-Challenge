import React from "react";
import { useParams } from "react-router-dom";

const MediaRenderer = (mediaFile) => {

    const {number} = useParams();
    console.log(mediaFile)
    return mediaFile != "" ? 
            <div className="container-fluid file">
                <a className="back btn btn-dark" type="button" href={`/media/${number}`}> 👈 GO BACK</a>
                <div className="card media-card">
                        <h1 className="title">{mediaFile.Name}</h1>
                        <h4 className="desc">Description: {mediaFile.Desc}</h4>
                        <h4 className="shortdesc">Summary: {mediaFile.ShortDesc}</h4>
                        <h4 className="genres">Genres: {
                            mediaFile.Genres.map(each => 
                                <span> &#160;{each.Name} &#160;</span>
                                )
                        }</h4>
                        <h4 className="images">Images: {
                            mediaFile.Images.length !== 0 ?
                            mediaFile.Images.map(image => 
                                <div>
                                <h5 className="image-type">--{image.Type}--</h5>
                                <img className="image" src={image.Url}/>
                                </div>
                                ) : <h5>No images available at the moment</h5>
                        }</h4>
                </div>
            </div> : <div className=" container-fluid error">
                <div className="container fluid err">
                <div >WE ARE UNABLE TO SERVE YOU AT THIS MOMENT<br/> SORRY FOR INCONVENIENCE<br/>🙁</div><br/>
                <a href={`/media/${number}`} type="btn" className="back btn btn-danger" >👈 GO BACK</a>
                </div>
            </div> 

}

export default MediaRenderer;