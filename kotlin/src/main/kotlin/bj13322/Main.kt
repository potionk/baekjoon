package bj13322

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (i in 0 until br.readLine().length) {
        bw.write("${i}\n")
    }
    bw.close()
    br.close()
}
