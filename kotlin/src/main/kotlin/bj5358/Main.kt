package bj5358

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var name = br.readLine()
    while (name != null) {
        name.forEach { c ->
            when (c) {
                'i' -> bw.write("e")
                'e' -> bw.write("i")
                'I' -> bw.write("E")
                'E' -> bw.write("I")
                else -> bw.write("$c")
            }
        }
        bw.write("\n")
        name = br.readLine()
    }
    bw.close()
}
