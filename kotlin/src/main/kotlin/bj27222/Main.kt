package bj27222

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    var result = 0
    for(i in 0 until n) {
        val (before, after) = br.readLine().split(" ").map { it.toInt() }
        if(list[i] == 1) {
            result += Math.max(0, after - before)
        }
    }
    println(result)
}
