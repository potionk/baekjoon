package bj25814

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ")
    val weightA = getWeight(a)
    val weightB = getWeight(b)
    if (weightA > weightB) {
        println(1)
    } else if (weightA < weightB) {
        println(2)
    } else {
        println(0)
    }
}

fun getWeight(str: String): Int {
    var weight = 0
    for (i in str.indices) {
        weight += str[i] - '0'
    }
    return weight * str.length
}
