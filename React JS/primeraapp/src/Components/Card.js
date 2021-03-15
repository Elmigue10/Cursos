import React from "react"
import excersiseImg from "../Images/exercise.png"
import "./Styles/Card.css"
import "bootstrap/dist/css/bootstrap.css"

const Card = ({title, description, img, leftColor, rightColor}) => (
    <div className="card mx-auto Fitness-Card"
    style={{
        backgroundImage: `url(${circlesImg}), linear-gradient(to right, ${leftColor || '#56CCF2'}  , ${rightColor|| '#2F80ED'}) `
    }}
>
    <div className="card-body">
        <div className="row center">
            <div className="col-6">
                <img src={img} className="float-right" alt="exercise"/>
                </div> 
                <div className="col-6 Fitness-Card-Info">
                    <h1>{this.props.title}</h1>
                    <p>{this.props.description}</p>
                </div>
            </div>
        </div>
</div>
)
export default Card
/* class Card extends React.Component{
    constructor(props){
        super(props)
        this.state={
            image:"https://firebasestorage.googleapis.com/v0/b/tutoriales-e4830.appspot.com/o/bulbasaur.png?alr=media&token=567caf19-af47-414e-a9d4-3854ab24c7dc"
        }
    }

    Despues de 5 segundos actualiza el estado del componente, en este caso inserta otra imagen
    componentDidMount(){
        setTimeout(()=>{
            this.setState({
                image:""
            })
        },5000)
    }

    render(){
        const {title, description, img, leftColor, rightColor} = this.props
            return (
               
            )
    }
} */

