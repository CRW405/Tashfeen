import numpy as np
from matplotlib import pyplot as plt

# setup data
# don't change the seed
RNG = np.random.default_rng(3)
normal = RNG.multivariate_normal
t, n = 3, 2500
spread = np.identity(2)
X = normal([-t, t], np.identity(2), n)
X = np.vstack((X, normal([t, t], spread, n)))
X = np.vstack((X, normal([t, -t], spread, n)))
X = np.vstack((X, normal([-t, -t], spread, n)))

# # plot data
# plt.title('Unlabelled Data Clusters')
# plt.xlabel('x--axis')
# plt.ylabel('y--axis')
# plt.plot(X[:, 0], X[:, 1], 'k.', alpha=0.3)
# plt.tight_layout()
# plt.show()

# algorithm
# how many clusters to find
# when to stop
epsilon = 10**-5
for K in [1,2,3,4]:
    # random starting points
    centroids = X[RNG.choice(X.shape[0], K, replace=False)]
    while True:
        # labels closest centroid for each point
        labels = np.array([np.argmin([np.linalg.norm(x-c) for c in centroids]) for x in X])
        # get new centroids
        new_centroids = np.array([X[labels == k].mean(axis=0) for k in range(K)])
        # check difference
        difference = np.linalg.norm(new_centroids - centroids)
        if difference < epsilon:
            break
        centroids = new_centroids

    # plot results
    plt.figure()
    plt.title('K-means Clustering')
    plt.xlabel('x--axis')
    plt.ylabel('y--axis')
    plt.scatter(X[:, 0], X[:, 1], c=labels, alpha=0.3)
    plt.scatter(centroids[:, 0], centroids[:, 1], c='red', marker='X')
    plt.tight_layout()
    plt.show()
