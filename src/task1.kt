package task1

import kotlin.math.sqrt

fun rectangleArea(width: Double, height: Double = width): Double {
    return width * height
}

fun circleArea(radius: Double, pi: Double = Math.PI): Double {
    return pi * radius * radius
}

fun triangleArea(a: Double, b: Double, c: Double): Double {
    val p = (a + b + c) / 2
    return sqrt(p * (p - a) * (p - b) * (p - c))
}

fun totalPerimeter(vararg sides: Double): Double {
    var sum = 0.0
    for (s in sides) sum += s
    return sum
}

fun main() {
    println("Площадь квадрата 5x5: ${rectangleArea(5.0)}")
    println("Площадь прямоугольника 4x7: ${rectangleArea(width = 4.0, height = 7.0)}")
    println("Площадь прямоугольника (позиционно): ${rectangleArea(4.0, 7.0)}")

    println("Площадь круга r=3: ${circleArea(3.0)}")
    println("Площадь круга r=3 с pi=3.14: ${circleArea(radius = 3.0, pi = 3.14)}")

    println("Площадь треугольника 3,4,5: ${triangleArea(3.0, 4.0, 5.0)}")
    println("Площадь треугольника 6,8,10: ${triangleArea(a = 6.0, b = 8.0, c = 10.0)}")

    println("Периметр (3,4,5): ${totalPerimeter(3.0, 4.0, 5.0)}")
    println("Периметр (2,2,2,2): ${totalPerimeter(2.0, 2.0, 2.0, 2.0)}")
}