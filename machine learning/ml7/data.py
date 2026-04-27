from matplotlib import pyplot as plt
import numpy as np

path = "./anderson.tsv"

classes = ['setosa', 'versicolor', 'virginica']
data = np.genfromtxt(path, delimiter="\t", dtype=str)
features = data[0]
Xy = data[1:].astype(np.float64)
X = Xy[:, :-1]
y = Xy[:, -1].astype(np.int64)

# # plotting
# if __name__ == '__main__':
#     plt.title('Iris Data')
#     plt.xlabel(features[0])
#     plt.ylabel(features[1])
#     handles, _ = plt.scatter(X[:, 0], X[:, 1], c=y).legend_elements()
#     plt.legend(handles, classes)
#     plt.tight_layout()
#     plt.show()

X = np.expand_dims(X, axis=-1)

training_idx = np.concatenate((
    np.arange(35), # 0-35 leaving 15 stosas
    50 + np.arange(35), # 50 - 85 leaving 15 vesti
    100 + np.arange(35) # 100 - 135 leaving 15 virginicas
    ))

X_ = np.delete(X, training_idx, axis=0)
Y_ = np.delete(y, training_idx, axis=0)
X = X[training_idx]
y = y[training_idx]

# one-hot encoding training labels
I = np.identity(len(np.unique(y)))
y = np.array([I[t] for t in y])

y = np.expand_dims(y, axis=-1)
# print(y)
