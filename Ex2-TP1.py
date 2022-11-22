import pandas as pd

#Series
#1
S1 = pd.Series([4, 7, -5, 3])
#2
print(S1)
#3
S2 = pd.Series([4, 7, -5, 3], index=['d', 'b', 'a','c'])
#4
print(S2)
#5
print(S1[1], S2['d'], S2['a'])
#6
print('La taille de la serie S1 est: ', len(S1))
#7
print('Les valuers positives de la serie S1 sont: ')
for el in S1:
    if el >= 0:
        print(el)

#DataFrames
Data = {
    "Company": ["Toyota", "Honda", "BMW", "Audi"],
    "Price": [23845, 17995, 135925, 71400]
}

#8
myDf = pd.DataFrame(Data)
#9
print("La dimesion est: ", myDf.shape, "\nLes noms des colonnes", myDf.columns, myDf.describe())
#10
print("La colonne company est:\n", myDf['Company'])
#11
print(myDf[['Company', 'Price']])
#12
print(myDf.loc[[0,len(myDf) - 1]][['Company']])
#13
print(myDf[['Company']].describe())
#14
print("After sorting values:\n", myDf.sort_values('Price'))
#15
print(myDf.loc[[3,1]])
#16
print('Value of first column, last row\n',myDf.iloc[len(myDf) - 1:, 0])
#17
print(myDf.loc[[0,1]])
#18
print(myDf.loc[[len(myDf) - 2,len(myDf) - 1]])
#19
print('First 3 lines & 2 first columns\n',myDf.iloc[0:3, 0:2])
#20
for index in myDf.index:
    if(myDf['Price'][index]>50000):
        print(myDf['Company'][index], myDf['Price'][index])
#21
#myDf = myDf.append(pd.DataFrame({'Company': ['Mercedes'], 'Price': [125478.196]}), ignore_index = True)
myDf = pd.concat([myDf, pd.DataFrame.from_records([{'Company': 'Mercedes', 'Price': 125478.196}])], ignore_index=True)
print(myDf)
#22
myDf = myDf.drop([2])
print(myDf)
#23
myDf['Horsepower'] = [111,  80, 182, 160]
print(myDf)