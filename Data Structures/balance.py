import random

# generate n string of randomized parethesis

arr = []

n = 10_000_000

for i in range(n):

    arr.append("")  
    
    for j in range(6):
        if random.randint(0,1) == 1:
            arr[i] += '('
        else:
            arr[i] += ')'

# check each one and see of theyre balanced and print %

bal = 0

for i in range(n):
    stack = 0
    balanced = True

    for char in arr[i]:
        if char == '(':
            stack +=1
        else:
            stack -=1
            if stack < 0:
                balanced = False
                break
    if stack == 0 and balanced:
        bal +=1

print ((bal / n)*100)