def solution(n):
#     text = '수박'
#     answer = ''
#     for i in range(n):
#         answer += text[i % 2]

#     return answer

    return ''.join(['수박'[i % 2] for i in range(n)])