package bj13871

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, c, s) = br.readLine().split(" ").map { it.toInt() }
    val commands = br.readLine().split(" ").map { it.toInt() }
    var current = 1
    var count = 0
    if (current == s) count++
    for (command in commands) {
        current += command
        if (current > n) current = 1
        if (current < 1) current = n
        if (current == s) count++
    }
    println(count)
}
