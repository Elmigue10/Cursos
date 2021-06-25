import {Router} from "express"
import * as taskController from "../controllers/task.controller"

const router = Router()

router.post("/", taskController.saveTask)

router.get("/", taskController.getAllTasks)

router.get("/done", taskController.findAllDoneTask)

router.get("/:id", taskController.getTaskById)

router.delete("/:id", taskController.deleteTask)

router.put("/:id", taskController.updateTask)

export default router