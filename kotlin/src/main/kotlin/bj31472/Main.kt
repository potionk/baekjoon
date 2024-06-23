package bj31472

import java.io.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    println(sqrt((n * 2).toDouble()).toInt() * 4)
    br.close()
}
