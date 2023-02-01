package de.springbootarchetype.domain

data class Task(
    val summary: String? = null,
    val description: String? = null,
    val dueDate: String? = null,
    val completed: Boolean = false,
    var uid: String? = null
)
