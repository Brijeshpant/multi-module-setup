import random

with open("products.csv","w") as file:
    file.write('id,name,category,price\n')
    count=1
    for user_id in range(1,100):
        for product_id in range(1,10):
         qut = random.randint(1, 6)
         total = qut*100
         file.write(f'{count},{user_id},{product_id},{qut},{total}\n')
         count =count+1