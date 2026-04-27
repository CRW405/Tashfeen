import numpy as np
from matplotlib import pyplot as plt
from data import X, y, X_, Y_

# architecture
p,h,l = X.shape[1], 8, y.shape[1]
biases = np.empty(2, dtype=object)
weights = np.empty(2, dtype=object)
biases[0], biases[1] = np.zeros((h, 1)), np.zeros((l, 1))
weights[0], weights[1] = np.zeros((h, p)), np.zeros((l, h))
L = len(weights) - 1

# network
def sigmoid(x):
    return 1 / (1 + np.exp(-x))

def feedforward(a, W, b, i=0):
    z = W[i] @ a + b[i]
    a = sigmoid(z)
    if i == L:
        return a
    return feedforward(a, W, b, i+1)

def backpropagation(a_last, t, W, b, i=0, gradient=[]):
    a = sigmoid(W[i] @ a_last + b[i])
    if i == L:
        pb = 2 * (a - t) * (a * (1 - a))
        pW = pb @ a_last.T
        return [(pb, pW)] + gradient
    gradient = backpropagation(a, t, W, b, i+1, gradient)
    pb_last = gradient[0][0]
    pb = (W[i+1].T @ pb_last) * (a * (1 - a))
    pW = pb @ a_last.T
    return [(pb, pW)] + gradient

def epoch(X,y,W,b,eta):
    for x, t in zip(X,y):
        gradient= backpropagation(x,t,W,b)
        for i in range(len(gradient)):
            b[i] -= eta * gradient[i][0]
            W[i] -= eta * gradient[i][1]

def rmse(y_pred, y):
    return np.sqrt(np.mean(np.mean((y_pred - y)**2, axis=1)))

eta = 0.1

errors = []
for i in range(350):
    epoch(X,y,weights,biases,eta)
    y_pred = np.array([feedforward(x, weights, biases) for x in X])
    errors.append(rmse(y_pred, y))

plt.title("Training Error")
plt.xlabel("Epoch")
plt.ylabel("RMSE")
plt.tight_layout()
plt.plot(errors)
plt.show()
