package bj5347

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toLong()
    for (i in 0 until n) {
        val ab = br.readLine().split(" ").map { it.toLong() }
        bw.write("${findLCM(ab[0], ab[1])}\n")
    }
    br.close()
    bw.close()
}

fun findLCM(a: Long, b: Long): Long {
    return (a * b) / findGCD(a, b)
}

fun findGCD(a: Long, b: Long): Long {
    if (b == 0L) return a
    return findGCD(b, a % b)
}
