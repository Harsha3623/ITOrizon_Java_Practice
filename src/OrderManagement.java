public interface OrderManagement {
     public abstract void addOrder();

     public abstract void viewOrder();

     //method overloading
     void viewOrder(String orderID);

     void markDelivered();

     void cancelOrder();

     void deleteOrder();

     void exit();

     void sortOrder();
}
