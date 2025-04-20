package bj2887

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val planets = mutableListOf<Planet>()
    for (i in 0 until n) {
        val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
        planets.add(Planet(i, x, y, z))
    }

    val edges = mutableListOf<Triple<Int, Int, Int>>()
    for (dim in listOf<(Planet) -> Int>({ it.x }, { it.y }, { it.z })) {
        val sorted = planets.sortedBy(dim)
        for (i in 0 until sorted.lastIndex) {
            val a = sorted[i]
            val b = sorted[i + 1]
            val cost = minOf(abs(a.x - b.x), abs(a.y - b.y), abs(a.z - b.z))
            edges.add(Triple(a.index, b.index, cost))
        }
    }

    val unionFind = UnionFind(n)
    var totalCost = 0
    var count = 0

    val sortedEdges = edges.sortedBy {it.third }
    for(edge in sortedEdges) {
        val (from, to, cost) = edge
        if (unionFind.union(from, to)) {
            totalCost += cost
            count++
        }
        if (count == n - 1) {
            break
        }
    }

    println(totalCost)
}

data class Planet(val index: Int, val x: Int, val y: Int, val z: Int)

private class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }

    fun union(a: Int, b: Int): Boolean {
        var aRoot = find(a)
        var bRoot = find(b)
        if (aRoot == bRoot) {
            return false
        }
        parent[bRoot] = aRoot
        return true
    }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
}
