package bj6887

import java.io.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println("The largest square has side length ${sqrt(br.readLine().toDouble()).toInt()}.")
    br.close()
}
