package bj27110

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val abc = br.readLine().split(" ").map { it.toInt() }
    var total = 0
    abc.forEach { total += min(it, n) }
    println(total)
}
