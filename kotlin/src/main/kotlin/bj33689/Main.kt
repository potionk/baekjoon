package bj33689

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    repeat(n) {
        if (br.readLine().startsWith('C')) count++
    }
    println(count)
}
