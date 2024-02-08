package bj31403

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    println(a + b - c)
    println((a.toString() + b.toString()).toInt() - c)
}
