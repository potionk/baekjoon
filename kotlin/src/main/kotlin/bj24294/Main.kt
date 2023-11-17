package bj24294

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val w1 = br.readLine().toInt()
    val h1 = br.readLine().toInt()
    val w2 = br.readLine().toInt()
    val h2 = br.readLine().toInt()
    print("${(h1 + h2 + max(w1, w2)) * 2 + 4}")
}
