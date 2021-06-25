import Task from "../models/Task"
import {getPagination, getPagintation} from "../libs/getPagination"

export const getAllTasks = async (req, res)=>{
    try {

        const { size, page, title } = req.query

        const condition = title ? {
            title : {$regex : new RegExp(title), $options: "{"}
        } : {}

        const { limit, offset } = getPagination(page, size)

        const data = await Task.paginate(condition,{
            offset,
            limit
        })

        res.json({
            totalItems: data.totalDocs,
            tasks : data.docs,
            totalPages: data.totalPages,
            currentPage: data.page - 1
        })
    } catch (error) {
        res.status(500).json({
            message : error.message || "Something was wrong."
        })
    }
}

export const saveTask = async (req, res)=>{

    if(!req.body.title){
        return res.status(500).json({
            message : "Content cannot be empty."
        })
    }

    try {
        const newTask = new Task({
        title: req.body.title,
        description: req.body.description ,
        done: req.body.done ? req.body.done : false
        })
    
        const taskSaved = await newTask.save()
        res.json(taskSaved)   
    } catch (error) {
        res.status(500).json({
            message : error.message || "Something was wrong."
        })
    }
}

export const findAllDoneTask = async(req,res)=>{
    const tasks = await Task.find({done:true})
    res.json(tasks)
}

export const getTaskById = async (req,res)=>{
    
    try {
        const { id } = req.params

        const task = await Task.findById(id)

        if(!task){ 
            return res.status(404).json({message: `Task with ${id} not exist`})
        }
        res.json(task)  
    } catch (error) {
        res.status(500).json({
            message : error.message || "Something was wrong."
        })
    }

}

export const deleteTask = async (req, res)=>{
    
    const { id } = req.params
    
    try {
        const task = await Task.findByIdAndDelete(id)
        res.json({
            message: `Se ha eliminado la tarea: ${task.title}`
        })
    } catch (error) {
        res.status(500).json({
            message : error.message || "Something was wrong."
        })
    }
}

export const updateTask = async (req, res)=>{
    await Task.findByIdAndUpdate(req.params.id, req.body)
    res.json("Task was update sucecsfully")
}