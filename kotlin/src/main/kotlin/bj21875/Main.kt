package bj21875

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val strA = br.readLine()
    val a = strA[0] - 'a' + 1
    val b = strA[1].toString().toInt()
    val strB = br.readLine()
    val c = strB[0] - 'a' + 1
    val d = strB[1].toString().toInt()
    val aDiff = Math.abs(a - c)
    val bDiff = Math.abs(b - d)
    println("${Math.min(aDiff, bDiff)} ${Math.max(aDiff, bDiff)}")
}
