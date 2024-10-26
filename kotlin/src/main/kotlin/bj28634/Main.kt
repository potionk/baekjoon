package bj28635

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().toInt()
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    println(
        if(a>b) m - a + b else abs(a - b)
    )
}