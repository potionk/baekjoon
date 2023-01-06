package bj26307

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val time = br.readLine().split(" ")
    val hour = time[0].toInt() - 9
    val minute = time[1].toInt()
    print("${hour * 60 + minute}")
}

