package bj17829

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val n = input[0].toInt()
    val matrix = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        matrix[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    print(calculateMatrix(matrix, 0, 0, n))
}

fun calculateMatrix(matrix: Array<IntArray>, topY: Int, leftX: Int, size: Int): Int {
    return if (size == 1) {
        matrix[topY][leftX]
    } else {
        val nextSize = size / 2
        val list = IntArray(4)
        list[0] = calculateMatrix(matrix, topY, leftX, nextSize)
        list[1] = calculateMatrix(matrix, topY, leftX + nextSize, nextSize)
        list[2] = calculateMatrix(matrix, topY + nextSize, leftX, nextSize)
        list[3] = calculateMatrix(matrix, topY + nextSize, leftX + nextSize, nextSize)
        list.sorted()[2]
    }
}
