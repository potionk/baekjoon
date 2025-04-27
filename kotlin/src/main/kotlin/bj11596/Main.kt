package bj11596

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val triangle1 = br.readLine().split(" ").map { it.toInt() }.sorted()
    val triangle2 = br.readLine().split(" ").map { it.toInt() }.sorted()

    if (isRightTriangle(triangle1) && isRightTriangle(triangle2) && area(triangle1) == area(triangle2)) {
        println("YES")
    } else {
        println("NO")
    }
}

fun isRightTriangle(tri: List<Int>): Boolean {
    return tri[0] * tri[0] + tri[1] * tri[1] == tri[2] * tri[2]
}

fun area(tri: List<Int>): Double {
    return tri[0].toDouble() * tri[1].toDouble() / 2
}
