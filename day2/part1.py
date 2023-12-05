import re

NUMBER_OF_STONES = {
    "red": 12,
    "green": 13,
    "blue": 14,
}


def parse() -> dict[int, str]:
    with open("input.txt") as f:
        lines = f.read().splitlines()
    games = {}

    for line in lines:
        game, stones = line[5:].split(":")
        games[int(game)] = stones

    return games


def is_valid(stones) -> bool:
    for color, amount in NUMBER_OF_STONES.items():
        for found_stones in re.findall(rf"(\d+) {color}", stones):
            if int(found_stones) > amount:
                return False
    return True


def solve() -> int:
    games = parse()
    total = 0
    for game, stones in games.items():
        if is_valid(stones):
            total += game
    return total


print(solve())
