package bj4690

fun main() {
    for (a in 1..100) {
        val a3 = a * a * a
        for (b in 2..a) {
            for (c in b + 1..a) {
                for (d in c + 1..a) {
                    if (a3 == b * b * b + c * c * c + d * d * d) {
                        println("Cube = $a, Triple = ($b,$c,$d)")
                    }
                }
            }
        }
    }
}
