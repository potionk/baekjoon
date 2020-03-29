import sys

test_case = int(sys.stdin.readline())


def make_blank(num):
    for i in range(num):
        print(" ", end="")


for i in range(test_case):
    make_blank(i)
    for _ in range((test_case - i)*2 - 1):
        print("*", end="")
    print("")
