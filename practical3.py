print("****** Fractional Knapsack ******")


n = int(input("Enter Number of Objects:"))
capacity = int(input("Enter Capacity of Knapsack:"))

items = []
max_prof = 0


for i in range(n):
    weight = int(input(f"Enter Object {i+1} Weight:" ))
    profit = int(input(f"Enter Object {i+1} Profit:" ))
    ratio = profit/weight
    items.append([weight,profit,ratio])

#sort
items.sort(key=lambda x:x[2],reverse=True)

for w,p,r in items:
    if w<=capacity:
        max_prof+=p
        capacity-=w
    else:
        max_prof += (capacity / w) * p
        break


print("maximum profit = ",max_prof)

