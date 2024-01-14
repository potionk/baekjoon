package bj24751

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().trim().toInt()
    println("%.10f".format(100.0 / a))
    println("%.10f".format(100.0 / (100 - a)))
}
