package bj17945

import java.io.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val discriminant = (2 * a.toDouble()).pow(2.0) - 4 * b
    println(
        listOf(
            ((-2 * a + sqrt(discriminant)) / 2).toInt(),
            ((-2 * a - sqrt(discriminant)) / 2).toInt()
        ).toSet().toList().sorted().joinToString(" ")
    )
}
