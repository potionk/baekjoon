package bj24723

import java.io.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(2.0.pow(br.readLine().toDouble()).toInt())
    br.close()
}
