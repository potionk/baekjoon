package bj11945

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val mn = br.readLine().split(" ").map { it.toInt() }
    for (i in 0 until mn[0]) {
        bw.write("${br.readLine().reversed()}\n")
    }
    bw.flush()
    br.close()
    bw.close()
}
