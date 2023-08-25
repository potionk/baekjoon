package bj15781

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    var result = br.readLine().split(" ").maxOfOrNull { it.toInt() }!!
    result += br.readLine().split(" ").maxOfOrNull { it.toInt() }!!
    println(result)
}
