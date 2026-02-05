from data import X, y, X_, y_

men = X[:, 1] == 1
women = X[:, 1] == 0

# print(sum(men) / (sum(men) + sum(women)))

men_survived = sum(y[men] == 1)
women_survived = sum(y[women] == 1)

print(
    "men: ",
    sum(men),
    "\nmen survived: ",
    men_survived,
    "\nwomen: ",
    sum(women),
    "\nwomen survived: ",
    women_survived,
    "\nmen%: ",
    men_survived / (sum(men) + sum(women)) * 100,
    "\nwomen%: ",
    women_survived / (sum(men) + sum(women)) * 100,
)
