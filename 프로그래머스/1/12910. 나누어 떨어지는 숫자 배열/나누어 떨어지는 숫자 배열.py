def solution(arr, divisor):
    answer = []
    arr.sort()
    for i in arr:
        if i % divisor == 0 :
            answer.append(i)
            
    if not answer :
        return [-1]
    
    return answer