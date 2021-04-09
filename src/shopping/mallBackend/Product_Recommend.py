# import libraries
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np

#read csv file
df = pd.read_excel('E:/dataset/products/product.xlsx')

# first few rows of dataset
print(df.head())
print(df.shape)
# import rating dataset
popularity = pd.read_excel("E:/dataset/products/popularity.xlsx")

# columns
print(popularity.columns)

# we need user id, movie id and rating
popularity = popularity.loc[:,["userID","productID","popularity"]]
print(popularity.head())

#then merge movie and rating data
df_origin = pd.merge(df,popularity)
print(df_origin.head())

print(df_origin.shape)

df = df_origin.iloc[:1000]
print(df.shape)

# basic stats
print(df.describe())

df.groupby("name").mean()['popularity'].sort_values(ascending=False)

df.groupby("name").count()["popularity"].sort_values(ascending=False)

popularity=pd.DataFrame(df.groupby("name").mean()['popularity'])
popularity['number of popularity']=pd.DataFrame(df.groupby("name").count()["popularity"])
print(popularity.head())

popularity.sort_values(by='popularity', ascending=False)

popularity.describe()

plt.hist(popularity['popularity'])
print(plt.show)

plt.hist(popularity['number of popularity'],bins=50)
print(plt.show)

pivot_table = df.pivot_table(index = ["userID"],columns = ["name"],values = "popularity")
pivot_table.head(5)

print(pivot_table.shape)

def recommend_product(product):
    product_watched = pivot_table[product]
    similarity_with_other_products = pivot_table.corrwith(product_watched)  # find correlation between laundry detergent and other product
    similarity_with_other_products = similarity_with_other_products.sort_values(ascending=False)
    return similarity_with_other_products.head()

print(recommend_product('coffee machine'))
