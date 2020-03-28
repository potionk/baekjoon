import sys

tc = int(sys.stdin.readline())

for _ in range(tc):
    R, E, C = map(int, sys.stdin.readline().split())
    if R < E - C:
        print("advertise")
    elif R == E - C:
        print("does not matter")
    else:
        print("do not advertise")
