def solution(arr):
    if (len(arr) == 1):
        return [-1]
    
    min_number = min(arr)
    min_count = arr.count(min_number)
    
    for i in range(min_count):
        arr.remove(min_number)
        
    return arr