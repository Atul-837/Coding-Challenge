import React from "react";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import Header from "./components/Header";
import MainPage from "./components/MainPage";
import MediaFile from "./components/MediaFile";
import MediaFileWithParams from "./components/MediaFileWithParams";
import MediaList from "./components/MediaList";
import "./css/App.css"


const App = () => {
    
    return ( 
            <div className="app">
                    <Header/>
                        <Router>
                            <Routes>
                                <Route exact path={"/media/filter/id=:mediaId/imageType=:imageType"} element = {<MediaFileWithParams/>}/>
                                <Route exact path="/media/:number/id/:id" element = {<MediaFile/>}/>
                                <Route exact path="/media/:number" element = {<MediaList/>}/>
                                <Route exact path="/" element = {<MainPage/>}/>
                            </Routes>
                        </Router>         
            </div>

    )
}

export default App;