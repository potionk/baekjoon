import sys

A, B = map(int, sys.stdin.readline().split())
div = A // B
rem = A % B
if B < 0:
    div += 1
    rem -= B

print(div)
print(rem)
