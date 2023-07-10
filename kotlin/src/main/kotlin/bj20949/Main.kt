package bj20949

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val ppis = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        ppis.add(Pair(i, w * w + h * h))
    }
    ppis.sortWith(compareBy({ -1 * it.second }, { it.first }))
    ppis.forEach { bw.write("${it.first}\n") }
    br.close()
    bw.close()
}
