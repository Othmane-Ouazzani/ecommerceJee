from asyncore import read
import os
import pandas as pd

#1
print(os.getcwd())
#2
print(os.listdir(os.getcwd()))
#3
Data = pd.read_csv("precipitation.csv", sep=",")
#4
print(Data.columns.values.tolist())
#5
DataWithoutHeader = pd.read_csv("precipitation.csv", sep=",", header=None, skiprows=1)
print(DataWithoutHeader)
#6
OnlyMonthAndPrecipitation = pd.read_csv("precipitation.csv", sep=",", usecols=['months', 'precip'])
print(OnlyMonthAndPrecipitation)
#7
Only10First = pd.read_csv("precipitation.csv", sep=",", nrows=10)
print(Only10First)
#8
Sales = pd.read_excel("sales.xls")
print(Sales)
#9
SalesBoth = pd.ExcelFile("sales.xls")
SalesSheet1 = pd.read_excel(SalesBoth, "week1")
SalesSheet2 = pd.read_excel(SalesBoth, "week2")
print(SalesSheet1)
print(SalesSheet2)
SalesBoth = pd.concat([SalesSheet1,SalesSheet2], ignore_index=True)
print(SalesBoth)
#Other Method
Sales2 = pd.read_excel("sales.xls", sheet_name=None)
print(Sales2)
#10
# Moyenne = SalesBoth.mean(numeric_only=True)
# print("La moyenne des chiffres de ventes est: ", float(Moyenne))
Moyenne1 = Sales2['week1'].mean(numeric_only=True)
Moyenne2 = Sales2['week2'].mean(numeric_only=True)
#11
average = pd.DataFrame({"Moyenne": [float(Moyenne1), float(Moyenne2)]}, index=['Week1', 'Week2'])
print(average)

writer = pd.ExcelWriter(os.getcwd() + "\\newSales.xls")
SalesSheet1.to_excel(writer, sheet_name='week1')
SalesSheet2.to_excel(writer, sheet_name='week2')
average.to_excel(writer, sheet_name='avg')
writer.save()
writer.close()
