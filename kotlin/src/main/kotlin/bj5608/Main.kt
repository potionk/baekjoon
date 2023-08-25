package bj5608

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        map[a] = b
    }
    val m = br.readLine().toInt()
    for (i in 0 until m) {
        val c = br.readLine()
        bw.write(map.getOrDefault(c, c))
    }
    bw.close()
}
