package bj9492

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.ceil

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) {
            break
        }
        val listA = mutableListOf<String>()
        val listB = mutableListOf<String>()
        val middle = ceil(n / 2.0).toInt()
        for (i in 0 until middle) {
            listA.add(br.readLine())
        }
        for (i in middle until n) {
            listB.add(br.readLine())
        }
        for (i in 0 until n) {
            if (i % 2 == 0) {
                println(listA[i / 2])
            } else {
                println(listB[i / 2])
            }
        }
    }
}
