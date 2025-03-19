package bj33571

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = mutableMapOf<Char, Int>()
    map['A'] = 1
    map['a'] = 1
    map['B'] = 2
    map['b'] = 1
    map['D'] = 1
    map['d'] = 1
    map['e'] = 1
    map['g'] = 1
    map['O'] = 1
    map['o'] = 1
    map['P'] = 1
    map['p'] = 1
    map['Q'] = 1
    map['q'] = 1
    map['R'] = 1
    map['@'] = 1
    var count = 0
    br.readLine().toCharArray().forEach {
        count += map[it] ?: 0
    }
    println(count)
}
