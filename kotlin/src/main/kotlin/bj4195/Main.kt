package bj4195

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()

    for (i in 0 until t) {
        val f = br.readLine().toInt()
        val unionFind = UnionFind(2 * f + 2)
        val idxMap = mutableMapOf<String, Int>()
        var nextIdx = 0

        for (j in 0 until f) {
            val (a, b) = br.readLine().split(" ")
            val idxA = idxMap.getOrPut(a) { nextIdx++ }
            val idxB = idxMap.getOrPut(b) { nextIdx++ }
            val networkSize = unionFind.union(idxA, idxB)
            bw.write("$networkSize\n")
        }
    }
    bw.close()
}

private class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }
    private val size = IntArray(n) { 1 }

    fun union(a: Int, b: Int): Int {
        var aRoot = find(a)
        var bRoot = find(b)
        if (aRoot == bRoot) {
            return size[aRoot]
        }
        if (size[aRoot] < size[bRoot]) {
            val temp = aRoot
            aRoot = bRoot
            bRoot = temp
        }
        parent[bRoot] = aRoot
        size[aRoot] += size[bRoot]
        return size[aRoot]
    }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
}
