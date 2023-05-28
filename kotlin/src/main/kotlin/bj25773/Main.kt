package bj25773

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val number = br.readLine().toCharArray()
    number.sorted().reversed().forEach { bw.write("$it") }
    br.close()
    bw.close()
}
