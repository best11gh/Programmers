n = int(input())
num_list = list(map(int, input().split()))

answer = 0

for x in num_list:    
    count = 0
    
    if x == 1:
        continue
    
    if x == 2:
        answer += 1
        continue
    
    for i in range(2, x):
        if x % i == 0:
            count += 1
            break
        
        if i > x / 2 + 1:
            break
     
    if count == 0:
        answer += 1
        

print(answer)