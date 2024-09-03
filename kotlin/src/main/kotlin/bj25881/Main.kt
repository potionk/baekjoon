package bj25881

import java.io.*
import kotlin.math.min
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val t = br.readLine().toInt()
    repeat(t) {
        val kwh = br.readLine().toInt()
        print("$kwh ")
        println((min(kwh, 1000)) * n + (max(0, kwh - 1000) * m))
    }
}
