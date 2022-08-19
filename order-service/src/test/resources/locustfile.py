import time
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    wait_time = between(1, 5)
    @task(1)
    def get_orders_by_user(self):
        for user_id in range(10):
            self.client.get(f"/api/orders/user/{user_id}")
