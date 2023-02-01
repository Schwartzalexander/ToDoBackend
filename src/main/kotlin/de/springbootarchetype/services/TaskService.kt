package de.springbootarchetype.services

import de.springbootarchetype.domain.Task
import de.springbootarchetype.util.RandomNameGenerator.generateName
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Service
class TaskService(
    private var environment: Environment,
) {
    private val tasksByUid = mutableMapOf<String, Task>()
    private val logger: Log = LogFactory.getLog(this.javaClass)

    @EventListener(ApplicationReadyEvent::class)
    fun initialize() {
        logger.info("Initializing App")
    }

    fun addTask(task: Task): String {
        val uid = generateUid()
        task.uid = uid
        tasksByUid[uid] = task
        return uid
    }

    fun updateTask(task: Task) {
        val uid = task.uid!!
        tasksByUid[uid] = task
    }

    fun deleteTask(uid: String) {
        tasksByUid.remove(uid)
    }

    fun getAllTasks() = tasksByUid.values.toList()

    private fun generateUid(): String {
        var uid = ""
        do {
            uid = "${generateName()}${generateName()}".replace(" ", "")
        } while (tasksByUid.containsKey(uid))
        return uid
    }


}