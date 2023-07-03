package bj6810

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    println("The 1-3-sum is ${9 * 1 + 7 * 3 + 8 * 1 + 0 * 3 + 9 * 1 + 2 * 3 + 1 * 1 + 4 * 3 + 1 * 1 + 8 * 3 + a * 1 + b * 3 + c * 1}")
    br.close()
}
