from urllib.request import urlopen as get

url = "https://www.gutenberg.org/files/20727/20727.txt"

with get(url) as res:
    text = res.read().decode("utf-8")

# print(text)
score = {}
allWords = []
for word in text.split(" "):
    if len(word) > 5:
        if word not in score:
            score.update({word: 1})
            allWords.append(word)
        else:
            score[word] += 1

# Get top 5 most used words
for word in sorted(score, key=score.get, reverse=True)[:5]:
    print(word, score[word])
