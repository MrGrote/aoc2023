import re
from functools import reduce
from operator import mul

COLORS = ["red", "green", "blue"]

with open("input.txt") as f:
    lines = f.read().splitlines()

total = 0
for line in lines:
    power = 1
    for color in COLORS:
        power *= max(map(int, re.findall(rf"(\d+) {color}", line)))
    total += power

print(total)
