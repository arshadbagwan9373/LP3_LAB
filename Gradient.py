# Gradient Descent for y = (x + 3)^2

x = 2          # starting point
lr = 0.1       # learning rate

print("Iteration\tX Value\tY Value")

for i in range(20):
    y = (x + 3)**2
    print(i, "\t\t", round(x, 4), "\t\t", round(y, 4))

    gradient = 2 * (x + 3)   # derivative
    x = x - lr * gradient

print("\nLocal minima at x =", round(x, 4))
print("Minimum value y =", round((x + 3)**2, 4))
