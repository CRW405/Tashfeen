from matplotlib import pyplot as plt
import numpy as np
import string

matrix = (np.arange(64).reshape(8, 8) % 2) ^ (np.arange(8)[:, None] % 2 == 0)

plt.imshow(matrix, cmap="grey")
plt.title("Chess Board Pattern")
plt.xticks([x for x in range(0, 8)], string.ascii_uppercase[:8])
plt.yticks([x for x in range(0, 8)], [x for x in range(1, 9)])

plt.tight_layout()

plt.show()
