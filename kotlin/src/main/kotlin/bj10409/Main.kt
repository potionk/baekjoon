package bj10409

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, T) = br.readLine().split(" ").map { it.toInt() }
    val tasks = br.readLine().split(" ").map { it.toInt() }
    var sum = 0
    var result = 0
    for(i in 0 until n) {
        sum += tasks[i]
        if(sum > T) {
            break
        }
        result++
    }
    println(result)
}
