package bj12871

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val t = br.readLine()
    val lcm = findLCM(s.length, t.length)
    println(
        if (s.repeat(lcm / s.length) == t.repeat(lcm / t.length)) {
            1
        } else {
            0
        }
    )
}

fun findLCM(a: Int, b: Int): Int {
    return (a * b) / findGCD(a, b)
}

fun findGCD(a: Int, b: Int): Int {
    if (b == 0) return a
    return findGCD(b, a % b)
}
