import matplotlib.pyplot as plt
import numpy as np

x = np.arange(1, 101)

# i = 1 while i < n
# top = 4 * (-1)^(i+1)
# bot = 2*i - 1

terms = (4 * (-1) ** (x + 1)) / (2 * x - 1)
fx = np.cumsum(terms)

err = (np.pi - fx) ** 2

# print(x)
# print(fx)
# print(err)

plt.title("Gregory Series")
plt.plot(x, fx, color="green", label="Gregory Series")
plt.plot(x, err, color="red", label="Error")
plt.xlabel("X")
plt.ylabel("Y")
plt.legend()
plt.tight_layout()

plt.tight_layout()
plt.show()
