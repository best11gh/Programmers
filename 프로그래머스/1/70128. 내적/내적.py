def solution(a, b):
    n = len(a)
    sum = 0
    for i in range(n):
        sum += a[i] * b[i]
    return sum
