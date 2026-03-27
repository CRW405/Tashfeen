import numpy as np
import matplotlib.pyplot as plot

# beta = (X^t X + lam Id)^-1 X^t y

# load
path = "./BostonHousing.csv"
Xy = np.genfromtxt(
    path,
    delimiter=",",
    skip_header=1,
    dtype=np.float64,
    converters={3: lambda s: float(s[1:-1])},
)

# select cols, add bias cols, target col
Xy = np.column_stack((Xy[:, 5], Xy[:, 12], np.ones(shape=Xy.shape[0]), Xy[:, -1]))

test = Xy[-100:]
train = Xy[:-100]

X, y = train[:, :-1], train[:, -1]
_X, _y = test[:, :-1], test[:, -1]

lamArr = np.arange(-9, 21)
rmseArr = []

for lam in lamArr:
    # get beta
    beta = np.linalg.inv(X.T @ X + lam * np.eye(X.shape[1])) @ X.T @ y
    # get error
    J = (_X @ beta - _y).T @ (_X @ beta - _y)
    rmseArr.append(np.sqrt(J / _X.shape[0]))

# plot
plot.plot(lamArr, rmseArr)
plot.xlabel("Lambda")
plot.ylabel("RMSE")
plot.title("Ridge Regression: RMSE vs Lambda")
plot.tight_layout()
plot.show()
