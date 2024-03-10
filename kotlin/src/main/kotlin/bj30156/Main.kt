package bj30156

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val str = br.readLine().trim()
        val aCount = str.count { it == 'a' }
        val bCount = str.length - aCount
        println(min(aCount, bCount))
    }
}
