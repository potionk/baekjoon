package bj20361

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, x, k) = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(n + 1) { 0 }
    array[x] = 1
    repeat(k) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        swap(array, a, b)
    }
    println(array.indexOf(1))
}

fun swap(array: IntArray, a: Int, b: Int) {
    val temp = array[a]
    array[a] = array[b]
    array[b] = temp
}
