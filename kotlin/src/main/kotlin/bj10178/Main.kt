package bj10178

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val cv = br.readLine().split(" ").map { it.toInt() }
        bw.write("You get ${cv[0] / cv[1]} piece(s) and your dad gets ${cv[0] % cv[1]} piece(s).\n")
    }
    br.close()
    bw.close()
}
