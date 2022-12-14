package bj25304

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val x = br.readLine().toInt()
    val n = br.readLine().toInt()
    var total = 0
    for (i in 0 until n) {
        val test = br.readLine().split(" ")
        total += test[0].toInt() * test[1].toInt()
    }
    bw.write(
        if (x == total) {
            "Yes"
        } else {
            "No"
        }
    )
    br.close()
    bw.close()
}
