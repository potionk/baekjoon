package bj15323

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Char, MutableList<String>>()
    val count = mutableMapOf<Char, Int>()
    repeat(k) {
        val str = br.readLine()
        map[str[0]] = map.getOrDefault(str[0], mutableListOf()).apply { add(str) }
    }
    map.forEach {
        it.value.sort()
    }
    repeat(n) {
        val c = br.readLine()[0]
        val idx = count.getOrDefault(c, 0) % map[c]!!.size
        bw.write("${map[c]!![idx]}\n")
        count[c] = idx + 1
    }
    bw.close()
}
