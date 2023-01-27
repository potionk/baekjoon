package bj9610

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val q = mutableListOf(0, 0, 0, 0)
    var axis = 0
    for (i in 0 until n) {
        val readLine = br.readLine().split(" ").map { it.toInt() }
        if (readLine[0] == 0 || readLine[1] == 0) {
            axis++
        } else if (readLine[0] > 0 && readLine[1] > 0) {
            q[0]++
        } else if (readLine[0] < 0 && readLine[1] > 0) {
            q[1]++
        } else if (readLine[0] < 0 && readLine[1] < 0) {
            q[2]++
        } else {
            q[3]++
        }
    }
    for (i in 1..4) {
        bw.write("Q$i: ${q[i - 1]}\n")
    }
    bw.write("AXIS: $axis")
    bw.flush()
    br.close()
    bw.close()
}
