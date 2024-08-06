package bj24087

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().toInt()
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    var total = 250
    var height = a
    while (height < s) {
        height += b
        total += 100
    }
    println(total)
}
