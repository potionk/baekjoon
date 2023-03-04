package bj20673

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val p = br.readLine().toInt()
    val q = br.readLine().toInt()
    if (p <= 50 && q <= 10) {
        println("White")
    } else if (q > 30) {
        println("Red")
    } else {
        println("Yellow")
    }
    br.close()
}
