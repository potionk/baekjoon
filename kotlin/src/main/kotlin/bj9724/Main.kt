package bj9724

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val list = mutableListOf<Int>()
    var i = 1
    while (true) {
        val cube = i * i * i
        if (cube > 2_000_000_000) {
            break
        }
        list.add(cube)
        i++
    }
    val t = br.readLine().toInt()
    for (it in 1..t) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        var count = 0
        list.forEach { n ->
            if (n in a..b) {
                count++
            }
            if (n > b) {
                return@forEach
            }
        }
        bw.write("Case #$it: $count\n")
    }
    bw.close()
}
