package bj11404

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val max = 10000001
    val dist = Array(n) { IntArray(n) { max } }

    for (i in 0 until n) {
        dist[i][i] = 0
    }

    for (i in 0 until m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        dist[a - 1][b - 1] = min(dist[a - 1][b - 1], c)
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (dist[i][j] == max) {
                bw.write("0 ")
            } else {
                bw.write("${dist[i][j]} ")
            }
        }
        bw.newLine()
    }
    bw.close()
}
