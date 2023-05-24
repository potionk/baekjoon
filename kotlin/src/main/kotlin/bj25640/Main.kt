package bj25640

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val jinho = br.readLine()
    val n = br.readLine().toInt()
    var count = 0
    for (i in 0 until n) {
        if (br.readLine() == jinho) {
            count++
        }
    }
    bw.write("$count")
    br.close()
    bw.close()
}
