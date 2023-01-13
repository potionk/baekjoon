package bj5426

import java.io.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val txt = br.readLine().toCharArray()
        val len = sqrt(txt.size.toDouble()).toInt()
        val encrypted = Array(len) { CharArray(len) }
        var idx = 0
        for (j in 0 until len) {
            for (k in 0 until len) {
                encrypted[j][k] = txt[idx++]
            }
        }
        for (j in len - 1 downTo 0) {
            for (k in 0 until len) {
                bw.write("${encrypted[k][j]}")
            }
        }
        bw.write("\n")
    }
    br.close()
    bw.close()
}
