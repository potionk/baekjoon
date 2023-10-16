package bj12723

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    for (n in 1..t) {
        br.readLine()
        val v1 = br.readLine().split(" ").map { it.toLong() }.sorted()
        val v2 = br.readLine().split(" ").map { it.toLong() }.sortedDescending()
        var result = 0L
        for (i in v1.indices) {
            result += v1[i] * v2[i]
        }
        bw.write("Case #$n: $result\n")
    }
    bw.close()
}
