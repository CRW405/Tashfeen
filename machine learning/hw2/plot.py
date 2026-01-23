import numpy as np
import matplotlib.pyplot as plt
from urllib.request import urlopen as get
import string

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

# Frequency

url = "https://www.gutenberg.org/files/20727/20727.txt"

with get(url) as res:
    text = res.read().decode("utf-8")

chars = []
for char in text:
    if char.isalpha():
        chars.append(char.upper())

score = {}
for char in chars:
    if char not in score:
        score.update({char: 1})
    else:
        score[char] += 1

score = dict(sorted(score.items(), key=lambda x: x[1], reverse=True))

# for letter in string.ascii_uppercase:
#     print(letter + " " + str(score[letter]))

x = []
y = []
for letter in string.ascii_uppercase:
    x.append(letter)
    y.append(score[letter])

sorted_pairs = sorted(zip(x, y), key=lambda pair: pair[1])
x, y = zip(*sorted_pairs)

plt.bar(x, y)
plt.title('Character Frequency in "The Cosmic Computer"')
plt.xlabel("Alphabet")
plt.ylabel("Frequency")
plt.legend()
plt.tight_layout()

plt.show()

# Chess

matrix = (np.arange(64).reshape(8, 8) % 2) ^ (np.arange(8)[:, None] % 2 == 0)

plt.imshow(matrix, cmap="grey")
plt.title("Chess Board Pattern")
plt.xticks([x for x in range(0, 8)], string.ascii_uppercase[:8])
plt.yticks([x for x in range(0, 8)], [x for x in range(1, 9)])

plt.tight_layout()

plt.show()

# AB

a = [[1, 0, 1], [2, 1, 1], [0, 1, 1], [1, 1, 2]]

b = [[1, 2, 1], [2, 3, 1], [4, 2, 2]]

print(np.matmul(a, b))

# Greg

x = np.arange(1, 101)

# i = 1 while i < n
# top = 4 * (-1)^(i+1)
# bot = 2*i - 1

terms = (4 * (-1) ** (x + 1)) / (2 * x - 1)
fx = np.cumsum(terms)

err = (np.pi - fx) ** 2

# print(x)
# print(fx)
# print(err)

plt.title("Gregory Series")
plt.plot(x, fx, color="green", label="Gregory Series")
plt.plot(x, err, color="red", label="Error")
plt.xlabel("X")
plt.ylabel("Y")
plt.legend()
plt.tight_layout()

plt.tight_layout()
plt.show()
