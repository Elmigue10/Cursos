import React from "react"
import "./Styles/Welcome.css"

const Welcom = ({userName})=>(
    <div className="container">
            <div className="Fitness-User-Info">
                <h1>Hello {userName}!</h1>
                <p>Let´s workout to get someone gains!</p>
            </div>
        </div>
)

export default Welcome