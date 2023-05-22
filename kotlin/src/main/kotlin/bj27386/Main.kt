package bj27386

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    br.readLine().toCharArray().toList().plus(br.readLine().toCharArray().toList()).sorted().forEach { bw.write("$it") }
    br.close()
    bw.close()
}
