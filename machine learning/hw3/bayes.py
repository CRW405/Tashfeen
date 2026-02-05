import numpy as np
from data import X, y, X_, y_


class NaiveBayes:
    def __init__(self, X, y):
        self.X = X
        self.Y = y

    def predict(self, x):
        return np.argmax([self.pr_y_given_x(0, x), self.pr_y_given_x(1, x)])

    def pr_y_given_x(self, y, x):
        # ???
        log_prob = np.log(self.pr_y(y))
        for i, xi in enumerate(x):
            log_prob += np.log(self.pr_xi_given_y(xi, i, y))
        return log_prob

    def pr_xi_given_y(self, xi, i, y):
        # probability of xi at i given y
        rows_with_y = self.X[self.Y == y]

        count = np.sum(rows_with_y[:, i] == xi)

        total = rows_with_y.shape[0]

        return count / total

    def pr_y(self, y):
        # probability of y
        return np.sum(self.Y == y) / self.Y.shape[0]


model = NaiveBayes(X, y)
if __name__ == "__main__":
    preds = [model.predict(x) for x in X_]
    accuracy = np.sum(preds == y_) / y_.shape[0]
    print(f"Accuracy: {accuracy}")
