package bj31775

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = mutableSetOf<Char>()
    repeat(3) {
        set.add(br.readLine()[0])
    }
    if (set.contains('l') && set.contains('k') && set.contains('p')) {
        println("GLOBAL")
    } else {
        println("PONIX")
    }
}
