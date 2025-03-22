public interface OrderManagement {
     public abstract void addOrder(String ordId, String ordDes, String deliAdd, double amount);

     public abstract void viewOrder();

     void viewOrder(String orderID);

     void markDelivered();

     void cancelOrder();

     void deleteOrder();
}
