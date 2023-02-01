package de.springbootarchetype.restControllers

import de.springbootarchetype.domain.Task
import de.springbootarchetype.domain.results.MessageResult
import de.springbootarchetype.domain.results.Result
import de.springbootarchetype.enums.Outcome
import de.springbootarchetype.services.TaskService
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(PATH_REST_CONTROLLERS)
class IndexRestController(
    private var environment: Environment,
    private val taskService: TaskService
) {
    private val logger: Log = LogFactory.getLog(this.javaClass)


    @PostMapping(PATH_REST_CONTROLLER_ADD_TASK)
    @Throws(Exception::class)
    fun addTask(@RequestBody task: Task): ResponseEntity<MessageResult> {
        val uid = taskService.addTask(task)
        return ResponseEntity(MessageResult(Outcome.OK, uid), HttpStatus.OK)
    }

    @PostMapping(PATH_REST_CONTROLLER_UPDATE_TASK)
    @Throws(Exception::class)
    fun updateTask(@RequestBody task: Task): ResponseEntity<Result> {
        if (task.uid == null)
            return ResponseEntity(MessageResult(Outcome.OK, "Task does not have a UID"), HttpStatus.BAD_REQUEST)
        taskService.updateTask(task)
        return ResponseEntity(Result.getInstanceOk(), HttpStatus.OK)
    }

    @PostMapping(PATH_REST_CONTROLLER_DELETE_TASK)
    @Throws(Exception::class)
    fun deleteTask(@RequestBody uid: String): ResponseEntity<Result> {
        taskService.deleteTask(uid)
        return ResponseEntity(Result.getInstanceOk(), HttpStatus.OK)
    }

    @GetMapping(PATH_REST_CONTROLLER_GET_ALL_TASKS)
    @Throws(Exception::class)
    fun getAllTasks(): ResponseEntity<List<Task>> {
        val allTasks = taskService.getAllTasks()
        return ResponseEntity(allTasks, HttpStatus.OK)
    }

}