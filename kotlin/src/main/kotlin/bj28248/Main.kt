package bj28248

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val p = br.readLine().toInt()
    val c = br.readLine().toInt()
    println(p * 50 + c * (-10) + if (p > c) 500 else 0)
}
