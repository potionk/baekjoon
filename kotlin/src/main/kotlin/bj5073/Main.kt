package bj5073

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }.sorted()
        if (a == 0 && b == 0 && c == 0) {
            break
        }
        if (a == b && b == c) {
            println("Equilateral")
        } else if (a + b <= c) {
            println("Invalid")
        } else if (a == b || b == c) {
            println("Isosceles")
        } else {
            println("Scalene")
        }
    }
    br.close()
}
