package task3

fun String.isValidEmail(): Boolean {
    val atIndex = indexOf('@')
    if (atIndex <= 0) return false
    val dotIndex = indexOf('.', atIndex)
    return dotIndex > atIndex + 1
}

fun String.maskPassword(): String {
    if (length <= 2) return "*".repeat(length)
    return first() + "*".repeat(length - 2) + last()
}

fun String.wordCount(): Int {
    return trim().split(Regex("\\s+")).count { it.isNotEmpty() }
}

fun Int.isEven(): Boolean = this % 2 == 0

fun Int.hoursToMinutes(): Int = this * 60

infix fun Int.timesRepeat(action: () -> Unit) {
    repeat(this) { action() }
}

fun <T> List<T>.secondOrNull(): T? = if (size >= 2) this[1] else null

fun <T> List<T>.thirdOrNull(): T? = if (size >= 3) this[2] else null

fun main() {
    println("test@mail.ru → ${"test@mail.ru".isValidEmail()}")
    println("invalid.email → ${"invalid.email".isValidEmail()}")
    println("a@b.c → ${"a@b.c".isValidEmail()}")

    println("secret123 → ${"secret123".maskPassword()}")
    println("ab → ${"ab".maskPassword()}")
    println("x → ${"x".maskPassword()}")

    println("Котлета 'Kotlin is cool' → ${"Kotlin is cool".wordCount()} слов")
    println("'  hello   world  ' → ${"  hello   world  ".wordCount()} слов")

    println("4 чётное? ${4.isEven()}")
    println("7 чётное? ${7.isEven()}")

    println("2 часа = ${2.hoursToMinutes()} минут")
    println("5 часов = ${5.hoursToMinutes()} минут")

    3 timesRepeat { println("Привет!") }

    println("secondOrNull [1,2,3]: ${listOf(1, 2, 3).secondOrNull()}")
    println("secondOrNull [1]: ${listOf(1).secondOrNull()}")
    println("thirdOrNull [1,2,3]: ${listOf(1, 2, 3).thirdOrNull()}")
    println("thirdOrNull [1,2]: ${listOf(1, 2).thirdOrNull()}")
}