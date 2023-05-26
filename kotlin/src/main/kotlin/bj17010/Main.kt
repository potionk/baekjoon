package bj17010

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (num, char) = br.readLine().split(" ")
        bw.write("${char.repeat(num.toInt())}\n")
    }
    br.close()
    bw.close()
}
