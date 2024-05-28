package bj31821

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val menu = mutableListOf<Int>()
    repeat(n) {
        menu.add(br.readLine().toInt())
    }
    val m = br.readLine().toInt()
    var total = 0
    repeat(m) {
        total += menu[br.readLine().toInt() - 1]
    }
    print(total)
}
