import numpy as np
from matplotlib import pyplot as plt

path = "./BostonHousing.csv"

Xy = np.genfromtxt(
    path,
    delimiter=",",
    skip_header=1,
    dtype=np.float64,
    converters={3: lambda s: float(s[1:-1])},
)

titles = [
    "CRIM     per capita crime rate by town",
    "ZN       proportion of residential land zoned for lots over 25,000 sq.ft.",
    "INDUS    proportion of non-retail business acres per town",
    "CHAS     Charles River dummy variable (= 1 if tract bounds river; 0 otherwise)",
    "NOX      nitric oxides concentration (parts per 10 million)",
    "RM       average number of rooms per dwelling",
    "AGE      proportion of owner-occupied units built prior to 1940",
    "DIS      weighted distances to five Boston employment centres",
    "RAD      index of accessibility to radial highways",
    "TAX      full-value property-tax rate per $10,000",
    "PTRATIO  pupil-teacher ratio by town",
    "B        1000(Bk - 0.63)^2 where Bk is the proportion of blacks by town",
    "LSTAT    % lower status of the population",
    "MEDV     Median value of owner-occupied homes in $1000's",
]

print(Xy.shape)
print(Xy[:, -1].min(), Xy[:, -1].mean(), Xy[:, -1].max())

for i in range(Xy.shape[1]):
    abbvr = titles[i].split(" ")[0]
    label = titles[i].split("  ")[-1]

    plt.title(abbvr)
    plt.xlabel(label)
    plt.ylabel("Median value of owner-occupied homes in $1000's")
    plt.plot(Xy[:, i], Xy[:, -1], "ko", alpha=0.5)
    plt.tight_layout()
    plt.show()

Xy = np.column_stack((Xy[:, 5], Xy[:, 12], np.ones(shape=Xy.shape[0]), Xy[:, -1]))
test = Xy[-100:]
train = Xy[:-100]
X, y = train[:, :-1], train[:, -1]
_X, _y = test[:, :-1], test[:, -1]

beta = np.linalg.inv(X.T @ X) @ X.T @ y
J = (_X @ beta - _y).T @ (_X @ beta - _y)

RMSE = np.sqrt(J / _X.shape[0])

print(RMSE)
