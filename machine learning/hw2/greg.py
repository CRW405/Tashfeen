import matplotlib.pyplot as plt
import numpy as np

x = np.arange(1, 101)

# i = 1 while i < n
# top = 4 * (-1)^(i+1)
# bot = 2*i - 1

fx = []

prev = 0
for i in x:
    prod = prev + ((4 * (-1) ** (i + 1)) / (2 * i - 1))
    fx.append(prod)
    prev = prod


err = []

for i in fx:
    err.append((np.pi - i) ** 2)

# print(x)
# print(fx)
# print(err)

plt.title("Gregory Series")
plt.plot(x, fx)
plt.plot(x, err)

plt.tight_layout()
plt.show()
