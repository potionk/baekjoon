package bj15372

import java.io.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        bw.write("${br.readLine().toDouble().pow(2).toLong()}\n")
    }
    bw.close()
}
