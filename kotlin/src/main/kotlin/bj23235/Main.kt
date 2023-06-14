package bj23235

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var count = 1
    while (br.readLine() != "0") {
        bw.write("Case ${count++}: Sorting... done!\n")
    }
    bw.close()
}
