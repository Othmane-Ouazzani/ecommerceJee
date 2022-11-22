import numpy as np

matA = np.array([[4, 6, -2, 3], [2, -1, 0, 1], [-7, 0, 1, 12]])

#print("La dimension de la matrice A est: ", matA.shape, "Le type des donnees: ", matA.dtype)
#print("La 3eme ligne est: ", matA[2], "La 2eme colonne est: ", matA[:, 1],)

for line in range(0, 2):
    for col in range(0, len(matA)):
        matA[line, col] *= 2

#print(matA)

matB = np.array([[4, 5, 6], [5, 10, 15], [1, 1, 1]])

matC = np.array(matA[0:3, 0:3])
#print(matC)

matD = np.dot(matB, matA)
matE = np.dot(matB, matC)
#print(matD, matE)

#With function sum
matSumE = np.sum(matE)
matSumD = np.sum(matD, axis=0)
print(matSumE, matSumD)

somme = 0

#With simple method
for line in matE:
    for col in line:
        somme += col
print(somme)

sommeD = np.zeros(3)
for i in range(0, matD.shape[0]):
    sommeD = np.sum(matD[i])
print(sommeD.astype(int))

#Replace negative values with 0 by clip function
matA = matA.clip(min = 0)
print(matA)

#With filter method
matA[matA < 0] = 0

#Replace negative values with 0 manually
for l in range(0, matA.shape[0]):
    for c in range(0, matA.shape[1]):
        if(matA[l, c] < 0):
            matA[l, c] = 0
print(matA)