package bj10810

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val nm = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(nm[0])
    for (i in 0 until nm[1]) {
        val info = br.readLine().split(" ").map { it.toInt() }
        for (j in info[0] - 1 until info[1]) {
            array[j] = info[2]
        }
    }
    array.forEach { bw.write("$it ") }
    br.close()
    bw.close()
}
