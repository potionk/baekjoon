package bj2346

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val balloons = br.readLine().split(" ").mapIndexed { index, s -> Pair(s.toInt(), index + 1) }.toMutableList()
    val result = mutableListOf<Int>()
    var index = 0
    var current = balloons[index].first
    result.add(1)
    balloons.removeAt(index)
    while (balloons.isNotEmpty()) {
        if (current > 0) {
            index = (index + current - 1) % balloons.size
        } else {
            index = (index + current) % balloons.size
            if (index < 0) {
                index += balloons.size
            }
        }
        current = balloons[index].first
        result.add(balloons[index].second)
        balloons.removeAt(index)
    }
    println(result.joinToString(" "))
}
