package bj24060

import java.io.BufferedReader
import java.io.InputStreamReader

var count = 0
var result = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }
    mergeSort(a.toIntArray(), 0, n - 1, k)
    println(result)
}

fun mergeSort(A: IntArray, p: Int, r: Int, k: Int) {
    if (p < r) {
        val q = (p + r) / 2
        mergeSort(A, p, q, k)
        if (result != -1) return
        mergeSort(A, q + 1, r, k)
        if (result != -1) return
        merge(A, p, q, r, k)
    }
}

fun merge(A: IntArray, p: Int, q: Int, r: Int, k: Int) {
    val tmp = IntArray(r - p + 1)
    var i = p
    var j = q + 1
    var t = 0
    while (i <= q && j <= r) {
        if (A[i] <= A[j]) {
            tmp[t++] = A[i++]
        } else {
            tmp[t++] = A[j++]
        }
    }
    while (i <= q) {
        tmp[t++] = A[i++]
    }
    while (j <= r) {
        tmp[t++] = A[j++]
    }
    i = p
    t = 0
    while (i <= r) {
        A[i++] = tmp[t++]
        count++
        if (count == k) {
            result = A[i - 1]
            return
        }
    }
}
