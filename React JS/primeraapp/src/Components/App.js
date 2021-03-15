import React from "react"
import {BrowserRouter, Route, Switch} from "react-router-dom"
import Excercises from "../Pages/Excercises"
import ExcercisesNewContainer from "../Pages/ExcercisesNewContainer"
import NotFound from "../Pages/NotFound"


const App = () => (
    <BrowserRouter>
        <Switch>
                <Route exact path="/excercise" component={Excercises}/>
                <Route exact path="/excercise/new" component={ExcercisesNewContainer}/>
                <Route component="NotFound"/>
        </Switch>
    </BrowserRouter>
)

export default App