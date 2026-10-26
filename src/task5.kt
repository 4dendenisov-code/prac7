package task5

data class Task(val id: Int, val title: String, val priority: String = "medium", var isDone: Boolean = false)

fun Task.format(): String {
    val mark = if (isDone) "✓" else " "
    return "[$mark] #$id $title ($priority)"
}

fun List<Task>.completedCount(): Int = count { it.isDone }
fun List<Task>.pendingCount(): Int = count { !it.isDone }

val tasks = mutableListOf<Task>()
var nextId = 1

fun addTask(title: String, priority: String = "medium"): Task {
    val task = Task(nextId++, title, priority)
    tasks.add(task)
    return task
}

fun markDone(id: Int) {
    tasks.find { it.id == id }?.apply { isDone = true }
}

fun removeTask(id: Int) {
    tasks.removeAll { it.id == id }
}

fun filterTasks(predicate: (Task) -> Boolean): List<Task> = tasks.filter(predicate)

fun printTasks(tasks: List<Task>) {
    if (tasks.isEmpty()) {
        println("(список пуст)")
        return
    }
    tasks.forEach { println(it.format()) }
}

fun main() {
    addTask("Купить молоко", "high")
    addTask("Сделать ДЗ", "low")
    addTask("Позвонить маме", "high")
    addTask("Погулять", "medium")
    addTask("Прочитать книгу", "low")

    markDone(1)
    markDone(3)
    removeTask(5)

    println("Все задачи:")
    printTasks(tasks)

    println("\nЗадачи с приоритетом high:")
    printTasks(filterTasks { it.priority == "high" })

    println("\nСтатистика: всего=${tasks.size}, выполнено=${tasks.completedCount()}, в процессе=${tasks.pendingCount()}")
}