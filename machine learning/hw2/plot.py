import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(-5 * np.pi, 5 * 10, 1000)

fx = x * np.sin(x) ** 2

gx = -x * np.sin(x) ** 2

plt.plot(x, fx, color="red", label="f(x) = x·sin²(x)")
plt.plot(x, gx, color="blue", label="g(x) = -x·sin²(x)")

plt.title("Trigonometric Functions")
plt.xlabel("x-axis")
plt.ylabel("y-axis")

plt.legend()

plt.grid(True, alpha=0.5)

plt.tight_layout()

plt.show()
