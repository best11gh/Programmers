def solution(numbers):
    number_list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    answer = 0
    for i in number_list:
        if i not in numbers:
            answer += i
            
    
    return answer