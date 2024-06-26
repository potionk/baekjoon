package bj26123

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, d) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    val max = arr.maxOrNull()!!
    val diff = kotlin.math.max(max - d, 0)
    var total = 0L
    arr.forEach {
        total += kotlin.math.max(it - diff, 0).toLong()
    }
    println(total)
}
