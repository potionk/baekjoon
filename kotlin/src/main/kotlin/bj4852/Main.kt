package bj4852

import java.io.*

val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var readLine = br.readLine()
    var partyNum = 1
    while (true) {
        bw.write("Party number $partyNum\n")
        val names = mutableListOf<String>()
        val connectMap = mutableMapOf<String, String>()
        val isVisited = mutableSetOf<String>()
        while (true) {
            if (readLine == "#") {
                names.forEach {
                    if (!isVisited.contains(it)) {
                        bw.write(it)
                        dfs(it, connectMap, isVisited)
                        bw.write(".\n")
                    }
                }
                partyNum++
                break
            }
            val connect = readLine.split(" ")
            names.add(connect[0])
            names.add(connect[1])
            connectMap[connect[0]] = connect[1]
            readLine = br.readLine()
        }
        readLine = br.readLine()
        if (readLine == "#") {
            break
        } else {
            bw.write("\n")
        }
    }
    bw.flush()
    br.close()
    bw.close()
}

fun dfs(name: String, connectMap: Map<String, String>, isVisited: MutableSet<String>) {
    if (!isVisited.contains(name)) {
        bw.write(" to ${connectMap[name]}")
        isVisited.add(name)
        dfs(connectMap[name]!!, connectMap, isVisited)
    }
}