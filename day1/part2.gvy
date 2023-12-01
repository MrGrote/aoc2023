def lineToNumber(line) {
    def wordToIntMap = [one: "1", two: "2", three: "3", four: "4", five: "5", six: "6", seven: "7", eight: "8", nine: "9"]
    
    String first
    String last
    line.eachWithIndex {
        c, i -> 
        if(Character.isDigit(c as char)) {
            if (first === null) { first = c }
            last = c
        }
        else {
            String parsed

            if(i+3 <= line.length() && wordToIntMap.containsKey(line[i..<i+3])) {
                parsed = wordToIntMap[line[i..<i+3]]
            }
            else if(i+4 <= line.length() && wordToIntMap.containsKey(line[i..<i+4])) {
                parsed = wordToIntMap[line[i..<i+4]]
            }
            else if(i+5 <= line.length() && wordToIntMap.containsKey(line[i..<i+5])) {
                parsed = wordToIntMap[line[i..<i+5]]
            }
            if (parsed !== null) {
                if (first === null) { first = parsed }
                last = parsed
            }
        }
    }
    (first + last) as int
}

def solve(lines) {
    lines.sum { lineToNumber(it) }
}

lines = new File("input.txt").readLines()
println "${solve lines}"