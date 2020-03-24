import sys

tc = str(sys.stdin.readline())
if (len(tc) - 1) % 2 == 0:
    half = tc[0:int((len(tc) - 1) / 2)]
    result = half + ''.join(reversed(half))
    if int(result) <= int(tc):
        before_len = len(half)
        half = int(half) + 1
        half = str(half)
        if before_len != len(half):
            result = half[0:-1] + "0" + "".join(reversed(half[0:-1]))
        else:
            result = half + ''.join(reversed(half))
    print(result)
else:
    half = tc[0:int((len(tc) - 1) / 2)]
    middle = tc[int((len(tc) - 1) / 2):int((len(tc) - 1) / 2) + 1]
    result = half + middle + ''.join(reversed(half))
    if int(result) <= int(tc):
        if int(middle) != 9:
            middle = int(middle) + 1
            middle = str(middle)
            result = half + middle + ''.join(reversed(half))
        else:
            if half == '':
                result = 11
            else:
                before_len = len(half)
                half = int(half) + 1
                half = str(half)
                if before_len != len(half):
                    result = half[0:-1] + "00" + "".join(reversed(half[0:-1]))
                else:
                    result = half + "0" + ''.join(reversed(half))
    print(result)