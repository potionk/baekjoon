package bj10698

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val regex = Regex("(\\d+)\\s+([+\\-])\\s+(\\d+)\\s+=\\s+(\\d+)")
    repeat(n) {
        val line = br.readLine()
        val matchResult = regex.find(line)!!
        val a = matchResult.groupValues[1].toInt()
        val op = matchResult.groupValues[2]
        val b = matchResult.groupValues[3].toInt()
        val c = matchResult.groupValues[4].toInt()
        println("Case ${it + 1}: ${checkAnswer(a, b, c, op)}")
    }
}

fun checkAnswer(a: Int, b: Int, c: Int, op: String): String {
    return if (op == "+") {
        if (a + b == c) "YES" else "NO"
    } else {
        if (a - b == c) "YES" else "NO"
    }
}
