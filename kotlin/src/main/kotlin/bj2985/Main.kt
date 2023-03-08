package bj2985

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val abc = br.readLine().split(" ").map { it.toInt() }
    val a = abc[0]
    val b = abc[1]
    val c = abc[2]
    if (a + b == c) {
        print("$a+$b=$c")
    } else if (a - b == c) {
        print("$a-$b=$c")
    } else if (a * b == c) {
        print("$a*$b=$c")
    } else if (a / b == c) {
        print("$a/$b=$c")
    } else if (a == b + c) {
        print("$a=$b+$c")
    } else if (a == b - c) {
        print("$a=$b-$c")
    } else if (a == b * c) {
        print("$a=$b*$c")
    } else if (a == b / c) {
        print("$a=$b/$c")
    }
    br.close()
}
