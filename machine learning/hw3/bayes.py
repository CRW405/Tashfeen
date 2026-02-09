import numpy as np
from data import X, y, X_, y_


class NaiveBayes:
    def __init__(self, X, y):
        self.X = X
        self.Y = y

    def predict(self, x):
        labels = np.unique(self.Y)
        prob = [self.pr_y_given_x(y, x) for y in labels]
        return np.argmax(prob)

    def pr_y_given_x(self, y, x):
        loggies = np.zeros(x.shape)
        for i, xi in enumerate(x):
            loggies[i] = np.log(self.pr_xi_given_y(xi, i, y))
        return np.sum(loggies) + np.log(self.pr_y(y))

    def pr_xi_given_y(self, xi, i, y):
        # probability of xi at i given y
        rows_with_y = self.X[self.Y == y]  # filtered

        count = np.sum(rows_with_y[:, i] == xi)

        total = rows_with_y.shape[0]

        probability = count / total

        return (
            probability if probability > 0 else 2 ** (-32)
        )  # if zero, then do really small number to avoid future log(0) error cause we're loop racist

    def pr_y(self, y):
        # probability of y
        return np.sum(self.Y == y) / self.Y.shape[0]


model = NaiveBayes(X, y)
if __name__ == "__main__":
    print(model.predict(np.array([3, 1, 20, 2])))
    preds = [model.predict(x) for x in X_]
    accuracy = np.sum(preds == y_) / y_.shape[0]
    print(f"Accuracy: {accuracy}")
