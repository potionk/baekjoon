package bj5613

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var result = br.readLine().toInt()
    while (true) {
        val operation = br.readLine()
        if (operation == "=") break
        val num = br.readLine().toInt()
        when (operation) {
            "+" -> result += num
            "-" -> result -= num
            "*" -> result *= num
            "/" -> result /= num
        }
    }
    println(result)
}
