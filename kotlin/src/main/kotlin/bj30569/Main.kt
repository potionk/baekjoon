package bj30569

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h1, d1, t1) = br.readLine().split(" ").map { it.toInt() }
    val (h2, d2, t2) = br.readLine().split(" ").map { it.toInt() }
    val result1 = getTimeToKill(h1, d2, t2)
    val result2 = getTimeToKill(h2, d1, t1)
    if (result1 < result2) {
        println("player two")
    } else if (result2 < result1) {
        println("player one")
    } else {
        println("draw")
    }
}

fun getTimeToKill(health: Int, damage: Int, reload: Int): Double {
    var time = 0.0
    var remain = health
    while (true) {
        time += 0.5
        remain -= damage
        if (remain <= 0) {
            return time
        }
        time += (reload - 0.5)
    }
}
