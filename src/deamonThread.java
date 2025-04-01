public class deamonThread extends Thread {
    public void run()
    {

        // Iterating to print more number of times
        for (int i = 0; i < 5; i++) {

            // Print statement
            System.out.println("Shot");

            // Making thread to sleep using sleep() method

            // Try catch block for exceptions
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
            }
        }
    }
}

