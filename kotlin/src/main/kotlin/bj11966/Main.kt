package bj11966

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val binaryN = br.readLine().toInt().toString(radix = 2).toCharArray()
    val count = binaryN.count { it == '1' }
    println(
        if (count == 1) {
            "1"
        } else {
            "0"
        }
    )
    br.close()
}