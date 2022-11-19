import React, { useState } from "react";
import "../css/MainPage.css"

const MainPage = () => {

    let [number, setNumber] = useState([])
    return  <div className="container-fluid main">
        <div className="container flex-column main-text">
            ENDLESS MOVIES AND WEBSERIES TO BINGEWATCH BECAUSE<br/>..... WINTER IS COMING..... <br/>
            <input name="number" className="input-value" placeholder="Enter no. from 1-10" onChange={(e) => setNumber(e.target.value)} /><br/>
            { number > 0 ?
            <a className="btn btn-dark get-start" type="button" href={`/media/${number}`}>GET STARTED</a> :
            <a className="btn btn-dark get-start" type="button" href="/">GET STARTED</a>
            }
        </div> 
    </div>

}

export default MainPage;