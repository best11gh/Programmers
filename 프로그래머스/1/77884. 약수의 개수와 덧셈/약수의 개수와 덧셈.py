def solution(left, right):
    sum = 0
    for number in range(left, right + 1):
        if float(number**(1/2)).is_integer():
            sum -= number
        else:
            sum += number
            
    return sum