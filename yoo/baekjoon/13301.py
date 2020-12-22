import sys
from functools import lru_cache
from collections import deque

@lru_cache
def fibo(n: int):
    return fibo(n-1) + fibo(n-2) if n >= 2 else n

def solution(a: int):
    if a==1:
        return 4
    elif a==2:
        return 6
    else:
        que = [fibo(x) for x in range(1,a+1)]
        num1 = que.pop()
        num2 = que.pop()
        round = (num1*2) + ((num1+num2)*2)
        return round


def main():
    a = list(map(int, sys.stdin.readline().split()))
    for i in a:
        print(solution(i))

            
if __name__=='__main__':
    main()