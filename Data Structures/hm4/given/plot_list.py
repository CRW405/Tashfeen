import numpy as np
from matplotlib import pyplot as plt
import csv

append_unclean_path = "./append.csv"
append_clean_path = "./cleaned_append.csv"
search_path = "./search.csv"

# Clean append.csv by removing the max value from each row
with (
    open(append_unclean_path, newline="") as unclean_file,
    open(append_clean_path, "w", newline="") as file,
):
    reader = csv.reader(unclean_file)
    writer = csv.writer(file)
    for row in reader:
        values = []
        for i in row:
            try:
                values.append(int(i))
            except ValueError:
                pass
        if values:
            maxValue = max(values)
            values.remove(maxValue)
        writer.writerow(values)

# Plotting both append and search results
fig, axs = plt.subplots(2, 1, figsize=(10, 10))

# Plot append.csv (cleaned)
title1 = "Nanoseconds taken by appending on an Array and Linked list."
xlabel1 = r"$i^{th}$ append"
ylabel1 = "Nanoseconds"
data_append = np.loadtxt(append_clean_path, delimiter=",")
axs[0].set_title(title1)
axs[0].set_xlabel(xlabel1)
axs[0].set_ylabel(ylabel1)
axs[0].plot(data_append[0], label="ArrayList")
axs[0].plot(data_append[1], label="LinkedList")
axs[0].legend()

# Plot search.csv (no cleaning)
title2 = "Nanoseconds taken by binary search on an Array and Linked list."
xlabel2 = r"List Size $2^i$"
ylabel2 = "Nanoseconds"
data_search = np.loadtxt(search_path, delimiter=",")
axs[1].set_title(title2)
axs[1].set_xlabel(xlabel2)
axs[1].set_ylabel(ylabel2)
axs[1].plot(data_search[0], label="ArrayList")
axs[1].plot(data_search[1], label="LinkedList")
axs[1].legend()

plt.tight_layout()
plt.savefig("plot.png")
