package bj18883

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    for (i in 0 until n) {
        for (j in 0 until m) {
            bw.write("${i * m + j + 1}")
            if (j < m - 1) bw.write(" ")
        }
        bw.write("\n")
    }
    bw.close()
}
