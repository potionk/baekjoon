package bj26509

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    repeat(n) {
        val t1 = reader.readLine().split(" ").map { it.toInt() }.sorted()
        val t2 = reader.readLine().split(" ").map { it.toInt() }.sorted()

        val isRightTriangle1 = t1[0] * t1[0] + t1[1] * t1[1] == t1[2] * t1[2]
        val isRightTriangle2 = t2[0] * t2[0] + t2[1] * t2[1] == t2[2] * t2[2]

        if (isRightTriangle1 && isRightTriangle2 && t1 == t2) {
            println("YES")
        } else {
            println("NO")
        }
    }
}
