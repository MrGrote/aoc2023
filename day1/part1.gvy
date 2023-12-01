import java.io.File

def lineToNumber(line) {
    def first
    def last
    line.each {
        if (Character.isDigit(it as char)) {
            if (first === null) { first = it }
            last = it
        }
    }
    (first + last) as int
}

def solve(lines) {
    lines.sum { lineToNumber(it) }
}

lines = new File("input.txt").readLines()
println "${solve lines}"