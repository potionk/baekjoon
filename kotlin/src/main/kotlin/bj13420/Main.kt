package bj13420

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t) {
        val input = br.readLine().split(" ")
        val operand1 = input[0].toLong()
        val operator = input[1]
        val operand2 = input[2].toLong()
        val answer = input[4].toLong()
        var result = 0L

        when (operator) {
            "+" -> result = operand1 + operand2
            "-" -> result = operand1 - operand2
            "*" -> result = operand1 * operand2
            "/" -> result = operand1 / operand2
        }

        if (result == answer) {
            println("correct")
        } else {
            println("wrong answer")
        }
    }
}
