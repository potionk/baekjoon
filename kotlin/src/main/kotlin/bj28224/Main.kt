package bj28224

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 0
    for (i in 0 until n) {
        result += br.readLine().toInt()
    }
    println(result)
}
