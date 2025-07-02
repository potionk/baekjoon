package bj25591

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    val a = 100 - x
    val b = 100 - y
    val c = 100 - (a + b)
    val d = a * b
    val q = d / 100
    val r = d % 100
    val front = c + q
    val back = r
    println("$a $b $c $d $q $r")
    println("$front $back")
}
