import numpy as np
from matplotlib import pyplot as plt

mean = [0, 0]
cov = [[1, 0.9], [0.9, 1]]

rng = np.random.default_rng(0)
X, y = rng.multivariate_normal(mean, cov, 100).T

X = np.vstack((X, np.ones(shape=X.shape))).T

beta = np.linalg.inv(X.T @ X) @ (X.T @ y)
m, b = beta

a = np.linspace(X.min(), X.max())
c = m * a + b

print(beta.shape)
print(X.shape)
print(y.shape)

plt.title("Linear Regression in Two Dimension")
plt.plot(X[:, 0], y, "ko", alpha=0.5, label="Data")
plt.plot(a, c, "bo", label="Fit")
plt.legend()
plt.tight_layout()
plt.savefig("bestfit.png")
plt.show()
