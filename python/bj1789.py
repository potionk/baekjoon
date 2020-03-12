import sys

tc = int(sys.stdin.readline())

count = 0
save = 0
index = 1
while (True):
    if save < tc:
        save += index
        index = index + 1
        count = count + 1
    else:
        break

print(count - 1)