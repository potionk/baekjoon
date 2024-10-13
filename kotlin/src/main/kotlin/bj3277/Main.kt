package bj3277

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val domains = mutableMapOf<String, Int>()
    repeat(n) {
        val domain = br.readLine()
        val key = getDomain(domain)
        domains[key] = domains.getOrDefault(key, 0) + 1
    }
    var max = 0
    domains.forEach {
        if (it.value > max) {
            max = it.value
        }
    }
    println(max)
    domains.forEach {
        if (it.value == max) {
            print("${it.key} ")
        }
    }
}

fun getDomain(domain: String): String {
    val removeHttp = if (domain.startsWith("http://")) {
        domain.removePrefix("http://")
    } else {
        domain
    }
    val split = removeHttp.split("/")[0].split(".")
    return split[split.size - 1]
}
