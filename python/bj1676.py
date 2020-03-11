import sys

tc = int(sys.stdin.readline())

count = 0
for i in range(1, tc + 1):
    if i % 5 == 0:
        if i % 125 == 0 and i >= 125:
            count = count + 3
        elif i % 25 == 0 and i >= 25:
            count = count + 2
        else:
            count = count + 1

print(count)
