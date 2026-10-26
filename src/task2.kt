package task2

typealias Operation = (Double, Double) -> Double

fun calculate(a: Double, b: Double, operation: Operation): Double {
    return operation(a, b)
}

fun main() {
    val operations: Map<String, Operation> = mapOf(
        "+" to { a, b -> a + b },
        "-" to { a, b -> a - b },
        "*" to { a, b -> a * b },
        "/" to { a, b -> if (b == 0.0) Double.NaN else a / b },
        "%" to { a, b -> if (b == 0.0) Double.NaN else a % b },
        "^" to { a, b -> Math.pow(a, b) },
        "max" to { a, b -> maxOf(a, b) }
    )

    println("Введите первое число:")
    val a = readln().toDoubleOrNull()
    println("Введите второе число:")
    val b = readln().toDoubleOrNull()
    println("Введите операцию (+, -, *, /, %, ^, max):")
    val op = readln()

    if (a == null || b == null) {
        println("Ошибка: введите корректные числа")
        return
    }

    val operation = operations[op]
    if (operation == null) {
        println("Ошибка: неизвестная операция '$op'")
    } else {
        val result = calculate(a, b, operation)
        println("Результат: $a $op $b = $result")
    }
}