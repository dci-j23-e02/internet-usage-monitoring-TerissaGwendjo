public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create UsageStats object for shared resource
        UsageStats usageStats = new UsageStats();

        // Create tasks with different delays and share the same UsageStats object
        Runnable facebookTask = new UsageMonitorTask("Facebook", 3000, usageStats);
        Runnable youtubeTask = new UsageMonitorTask("YouTube", 3000, usageStats);
        Runnable whatsappTask = new UsageMonitorTask("WhatsApp", 3000, usageStats);
        Runnable slackTask = new UsageMonitorTask("Slack", 1000, usageStats); // Shorter delay for Slack

        // Create threads for the tasks
        Thread facebookThread = new Thread(facebookTask);
        Thread youtubeThread = new Thread(youtubeTask);
        Thread whatsappThread = new Thread(whatsappTask);
        Thread slackThread = new Thread(slackTask);

        // Start the threads
        facebookThread.start();
        youtubeThread.start();
        whatsappThread.start();
        slackThread.start();

        // Let the tasks run for a certain amount of time (e.g., 30 seconds)
        Thread.sleep(30000);

        // Interrupt the tasks, simulating a shutdown or cancellation
        facebookThread.interrupt();
        youtubeThread.interrupt();
        whatsappThread.interrupt();
        slackThread.interrupt();

        // Wait for all threads to finish
        facebookThread.join();
        youtubeThread.join();
        whatsappThread.join();
        slackThread.join();

        // Print the final data usage statistics
        usageStats.printDataUsage();

        // All tasks are complete
        System.out.println("Internet usage monitoring tasks have been completed.");
    }
}