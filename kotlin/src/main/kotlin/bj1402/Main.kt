package bj1402

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        br.readLine()
    }
    bw.write("yes\n".repeat(n))
    br.close()
    bw.close()
}
