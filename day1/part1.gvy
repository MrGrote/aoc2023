import java.io.File

class Example {
    static void main(String[] args) {
        int total = 0
        new File("input.txt").eachLine {
            line ->
                String first
                String last
                line.each {
                    c -> 
                        if(Character.isDigit(c as char)) {
                            if (first === null) {
                                first = c
                            }
                            last = c
                        }
                }
                total += Integer.parseInt(first + last)
        }
        println total
   }
}