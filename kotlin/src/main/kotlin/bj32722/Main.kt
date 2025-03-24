package bj32722

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    if (!(a == 1 || a == 3)) {
        println("EI")
        return
    }
    if (!(b == 6 || b == 8)) {
        println("EI")
        return
    }
    if (!(c == 2 || c == 5)) {
        println("EI")
        return
    }
    println("JAH")
}
