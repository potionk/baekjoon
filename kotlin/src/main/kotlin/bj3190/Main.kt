package bj3190

import java.io.*

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val apples = mutableSetOf<Pair<Int, Int>>()
    repeat(k) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        apples.add(x to y)
    }
    val l = br.readLine().toInt()
    val directions = mutableListOf<Pair<Int, Char>>()
    repeat(l) {
        val (x, c) = br.readLine().split(" ")
        directions.add(x.toInt() to c[0])
    }
    var time = 0
    var direction = 0
    var x = 1
    var y = 1
    val snake = mutableListOf(x to y)
    val snakeSet = mutableSetOf(x to y)
    while (true) {
        time++
        x += dx[direction]
        y += dy[direction]
        if (!validate(x, y, n) || snakeSet.contains(x to y)) {
            break
        }
        snake.add(x to y)
        snakeSet.add(x to y)
        if (apples.contains(x to y)) {
            apples.remove(x to y)
        } else {
            snakeSet.remove(snake.removeAt(0))
        }
        if (directions.isNotEmpty() && time == directions[0].first) {
            direction = when (directions[0].second) {
                'L' -> (direction + 3) % 4
                'D' -> (direction + 1) % 4
                else -> direction
            }
            directions.removeAt(0)
        }
    }
    println(time)
}

private fun validate(x: Int, y: Int, n: Int): Boolean {
    return x in 1..n && y in 1..n
}
