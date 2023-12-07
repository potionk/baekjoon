package bj26560

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    repeat(n) {
        val str = br.readLine()
        bw.write("$str${if (str.last() != '.') "." else ""}\n")
    }
    bw.close()
}
