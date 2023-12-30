package bj28701

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    println((1..n).sum())
    println((1..n).sum().let { it * it })
    println((1..n).sumOf { it * it * it })
}
