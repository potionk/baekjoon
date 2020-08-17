import sys

for i in range(3):
    tc = int(sys.stdin.readline())
    total = 0
    for j in range(tc):
        total += int(sys.stdin.readline())
    if total == 0:
        print(0)
    elif total < 0:
        print("-")
    else:
        print("+")
