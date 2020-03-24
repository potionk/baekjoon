import sys

test_case = int(sys.stdin.readline())

for _ in range(test_case):
    a, b = map(int, sys.stdin.readline().split())
    result = a
    for i in range(1, b):
        result = (result * a) % 10
    if result == 0:
        print(10)
    else:
        result = result % 10
        if result == 0:
            print(10)
        else:
            print(result)