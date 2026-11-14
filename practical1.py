def fibo_iterative(n):
    a=0
    b=1
    c=-1
    for i in range(0,n):
        print(a , end = " ")
        c = a+b
        a = b
        b = c



def fibo_recur(n):
    if n<=1:
        return n
    return fibo_recur(n-1) + fibo_recur(n-2)


n = int ( input("Enter Number of terms :"))

print("****** ITERATIVE APPROACH ******")


fibo_iterative(n)

print("\n-----------------------------------")

print("\n****** RECURSIVE APPROACH ******")

for i in range(0,n):
    print(fibo_recur(i) , end = " ")

print("\n-----------------------------------")