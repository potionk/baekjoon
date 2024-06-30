package bj1350

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val files = br.readLine().split(" ").map { it.toLong() }
    val clusterSize = br.readLine().toLong()
    var totalSize = 0L
    for (file in files) {
        totalSize += (file + clusterSize - 1) / clusterSize * clusterSize
    }
    println(totalSize)
}
