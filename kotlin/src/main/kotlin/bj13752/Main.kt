package bj18405

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val k = br.readLine().toInt()
        bw.write("${"=".repeat(k)}\n")
    }
    bw.close()
}
