package bj26566

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.PI
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    repeat(n) {
        val (a1, p1) = br.readLine().split(" ").map { it.toDouble() }
        val (r1, p2) = br.readLine().split(" ").map { it.toDouble() }

        val wholeValue = (PI * r1.pow(2)) / p2
        val sliceValue = a1 / p1

        if (wholeValue > sliceValue) {
            println("Whole pizza")
        } else {
            println("Slice of pizza")
        }
    }
}