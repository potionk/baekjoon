package bj5349

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var ssn = br.readLine()
    val duplicateCheckSet = mutableSetOf<String>()
    val duplicateSSNs = mutableListOf<String>()
    while (ssn != "000-00-0000") {
        if (!duplicateCheckSet.contains(ssn)) {
            duplicateCheckSet.add(ssn)
        } else {
            duplicateSSNs.add(ssn)
        }
        ssn = br.readLine()
    }
    duplicateSSNs.distinct().sorted().forEach {
        bw.write("$it\n")
    }
    bw.flush()
    br.close()
    bw.close()
}
