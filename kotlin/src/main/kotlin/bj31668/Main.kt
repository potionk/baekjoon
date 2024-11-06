package bj31668

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val k = br.readLine().toInt()
    println(m / n * k)
}
