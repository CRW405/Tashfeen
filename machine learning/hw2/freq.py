from urllib.request import urlopen as get
import matplotlib.pyplot as plt
import string

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
