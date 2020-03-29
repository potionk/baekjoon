import sys

test_case = int(sys.stdin.readline())
count = 0
stage = 1

for i in range(test_case):
    if i + 1 == 10:
        stage = 2
    elif i + 1 == 100:
        stage = 3
    elif i + 1 == 1000:
        stage = 4
    elif i + 1 == 10000:
        stage = 5
    elif i + 1 == 100000:
        stage = 6
    elif i + 1 == 1000000:
        stage = 7
    elif i + 1 == 10000000:
        stage = 8
    elif i + 1 == 100000000:
        stage = 9
    count += stage

print(count)
