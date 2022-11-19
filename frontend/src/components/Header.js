import React, { useState } from "react";
import { useActionData } from "react-router-dom";
import "../css/Header.css"


const Header = () => {

    let [id, setId] = useState([])
    let [imageType, setImageType] = useState([])

    return <nav className="navbar">
    <div className="container-fluid">
      <a href="/"><img className="navbar-brand" src={"/logo1.png"}></img></a>
      <form className="d-flex input" role="search">
        <input className="form-control me-2 input-box" type="search" 
        onChange={(e) => setId(e.target.value)} placeholder="Enter ID" aria-label="Search"/>
        <input className="form-control me-2 input-box" type="search" 
        onChange={(e) => setImageType(e.target.value)} placeholder="Enter ImageType" aria-label="Search"/>
        <a className="btn btn-outline-secondary search" 
        href={`/media/filter/id=${id}/imageType=${imageType}`} type="submit">Search</a>
      </form>
   </div>
  </nav>
}

export default Header;  