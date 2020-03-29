import sys

test_case = int(sys.stdin.readline())


def calStat(hp, mp, attack, defense, eq_hp, eq_mp, eq_att, eq_def):
    after_hp = hp + eq_hp
    if after_hp < 1:
        after_hp = 1
    after_mp = mp + eq_mp
    if after_mp < 1:
        after_mp = 1
    after_att = attack + eq_att
    if after_att < 0:
        after_att = 0
    after_def = defense + eq_def
    return after_hp + 5 * after_mp + 2 * after_att + 2 * after_def


for _ in range(test_case):
    hp, mp, attack, defense, eq_hp, eq_mp, eq_att, eq_def = map(int, sys.stdin.readline().split())
    print(calStat(hp, mp, attack, defense, eq_hp, eq_mp, eq_att, eq_def))
