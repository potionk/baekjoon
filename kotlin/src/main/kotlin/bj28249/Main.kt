package bj28249

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var total = 0
    for (i in 0 until n) {
        val input = br.readLine()
        when (input) {
            "Poblano" -> total += 1500
            "Mirasol" -> total += 6000
            "Serrano" -> total += 15500
            "Cayenne" -> total += 40000
            "Thai" -> total += 75000
            "Habanero" -> total += 125000
        }
    }
    println(total)
}
