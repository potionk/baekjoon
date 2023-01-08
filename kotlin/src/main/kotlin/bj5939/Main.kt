package bj5939

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val times = mutableListOf<Time>()
    for (i in 0 until n) {
        val readLine = br.readLine().split(" ")
        times.add(Time(readLine[0].toInt(), readLine[1].toInt(), readLine[2].toInt()))
    }
    val sorted = times.sortedWith(compareBy<Time> { it.hour }.thenBy { it.min }.thenBy { it.sec })
    sorted.forEach {
        bw.write("${it.hour} ${it.min} ${it.sec}\n")
    }
    bw.flush()
    bw.close()
    br.close()
}

class Time(val hour: Int, val min: Int, val sec: Int)