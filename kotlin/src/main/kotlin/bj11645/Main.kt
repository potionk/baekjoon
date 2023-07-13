package bj11645

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val set = mutableSetOf<String>()
        val m = br.readLine().toInt()
        for (j in 0 until m) {
            set.add(br.readLine())
        }
        bw.write("${set.size}\n")
    }
    br.close()
    bw.close()
}
