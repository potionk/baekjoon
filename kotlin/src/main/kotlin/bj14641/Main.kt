package bj14641

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val mappingTable = mutableMapOf<Char, MutableSet<Char>>()
    repeat(m) {
        val (key, value) = br.readLine().split(" ")
        val set = mappingTable[key[0]] ?: mutableSetOf()
        set.add(value[0])
        mappingTable[key[0]] = set
    }
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        var isPossible = true
        if (a.length != b.length) {
            isPossible = false
        } else {
            for (j in a.indices) {
                if (!dfs(a[j], b[j], mappingTable, mutableSetOf())) {
                    isPossible = false
                    break
                }
            }
        }
        println(if (isPossible) "yes" else "no")
    }
}

fun dfs(a: Char, b: Char, mappingTable: Map<Char, Set<Char>>, isVisited: MutableSet<Char>): Boolean {
    if (isVisited.contains(a)) {
        return false
    }
    isVisited.add(a)
    if (a == b) {
        return true
    }
    val set = mappingTable[a] ?: return false
    return set.any { dfs(it, b, mappingTable, isVisited) }
}
