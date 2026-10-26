package task4

data class User(val name: String, var email: String?, var age: Int, var isActive: Boolean = false)
data class Config(var host: String, var port: Int, var timeout: Int = 30)

fun main() {
    val user = User("Иван", null, 25)
    user.email?.let { println("Email: $it") } ?: println("Email не указан")
    user.apply {
        email = "user@mail.ru"
        isActive = true
    }
    println("Пользователь: $user")

    val config = Config("localhost", 8080)
    config.apply {
        port = 3000
        timeout = 60
    }.also {
        println("Конфиг создан: $it")
    }
    println("Итоговый config: $config")

    val (trimmed, upper, len) = " Kotlin is Awesome ".run {
        val t = trim()
        Triple(t, t.uppercase(), t.length)
    }
    println("trimmed='$trimmed', upper='$upper', len=$len")

    val stats = with(listOf(10, 20, 30)) {
        Triple(sum(), average(), max())
    }
    println("Сумма=${stats.first}, Среднее=${stats.second}, Максимум=${stats.third}")

    val nullableList: List<Int>? = listOf(1, 2, 3)
    nullableList?.let { println("Сумма nullable-списка: ${it.sum()}") }
}