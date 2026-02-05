import numpy as np

# Select relevant columns: passenger class, sex, age, fare
keep = [0, 3, 4, 8]
keep += [1]  # Add survival column (our target/label)

# Map categorical text values to numbers
# Ports: Cherbourg=0, Queenstown=1, Southampton=2
encoding = {"female": 0, "male": 1, "C": 0, "Q": 1, "S": 2}

# Load CSV file, skip header row
data = np.loadtxt("./titanic.csv", skiprows=1, delimiter=",", dtype=object)

# Keep only the selected columns and transpose
data = np.vstack([data[:, j] for j in keep]).T

# Remove rows with missing/empty values
data = data[np.sum(data == "", axis=1) == 0]

# Replace text values with their numeric encodings
for k in encoding:
    data[data == k] = encoding[k]

# Convert to floats and round up (e.g., age 5.5 becomes 6.0)
data = np.ceil(data.astype(np.float64))

# Create balanced test set: first 50 survivors (label=1)
arg_test = np.argwhere(data[:, -1] == 1).flatten()[:50]
# Add first 50 non-survivors (label=0) for total of 100 test samples
arg_test = np.hstack((arg_test, np.argwhere(data[:, -1] == 0).flatten()[:50]))

# Split into test and training sets
data_test = data[arg_test]
data = np.delete(data, arg_test, axis=0)

# Split features (X) and labels (y) for training
X, y = data[:, :-1], data[:, -1]
# Split features (X_) and labels (y_) for testing
X_, y_ = data_test[:, :-1], data_test[:, -1]
