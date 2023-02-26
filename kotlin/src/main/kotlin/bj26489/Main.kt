package bj26489

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = 0
    while (br.readLine() != null) {
        count++
    }
    println(count)
    br.close()
}
