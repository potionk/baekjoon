package bj6438

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        bw.write(br.readLine().reversed() + "\n")
    }
    br.close()
    bw.close()
}
