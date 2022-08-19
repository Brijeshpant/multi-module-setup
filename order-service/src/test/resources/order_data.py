import random

with open("orders.csv","w") as file:
    file.write('id,user_id,product_id,quantity,order_total\n')
    count=1
    for user_id in range(1,1000):
        for product_id in range(1,10):
         qut = random.randint(1, 6)
         total = qut*100
         file.write(f'{count},{user_id},{product_id},{qut},{total}\n')
         count =count+1