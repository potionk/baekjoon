package bj11580

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val commands = br.readLine().toCharArray()
    val visited = mutableSetOf<Pair<Int, Int>>()
    var y = 0
    var x = 0
    visited.add(Pair(y, x))
    for (command in commands) {
        when (command) {
            'E' -> x++
            'W' -> x--
            'S' -> y--
            'N' -> y++
        }
        visited.add(Pair(y, x))
    }
    println(visited.size)
}
