package bj5220

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val aBinary = a.toString(2)
        val oneCount = aBinary.count { it == '1' }
        println(
            if (oneCount % 2 == 0) {
                if (b == 0) {
                    "Valid"
                } else {
                    "Corrupt"
                }
            } else {
                if (b == 1) {
                    "Valid"
                } else {
                    "Corrupt"
                }
            }
        )
    }
}
