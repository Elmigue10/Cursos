import React from "react"
import Card from "./Card"

const ExcerciseList = ({exercises}) =>(
    <div>
        {exercises.map((excercise) =>{
                    return (
                        <Card 
                            key={exercise.id}
                            {...excercise}
                        />
                    )
                })
            }
    </div>
)

export default ExcerciseList