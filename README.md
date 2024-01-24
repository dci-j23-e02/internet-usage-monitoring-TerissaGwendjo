
# Internet Usage Monitoring

## Overview
In this assignment, you will create a Java application that simulates monitoring internet usage for different applications: Facebook, YouTube, WhatsApp, and Slack. The application will simulate the scenario where Slack is the most heavily used application and therefore should be monitored more frequently.

## Objectives
- Understand how to create and manage threads in Java.
- Learn how to use the `sleep()` method to simulate time delays.
- Practice simulating different usage patterns for multiple applications.

## Requirements
- You are required to create a Java application that monitors internet usage for the specified applications.
- Each application will have its own monitoring thread.
- The Slack application should be monitored more frequently to reflect its heavy usage.
- The application should simulate monitoring for a fixed duration (e.g., 30 seconds) and then gracefully shut down.
- The expected result is that the application will output the simulated internet usage monitoring logs for each application, with Slack logs appearing more frequently.

## Tasks
1. Define a `UsageMonitorTask` class that implements `Runnable`. This class will simulate monitoring internet usage for a given application.

```java
class UsageMonitorTask implements Runnable {
    private String appName;
    private int delay;

    public UsageMonitorTask(String appName, int delay) {
        this.appName = appName;
        this.delay = delay;
    }

    @Override
    public void run() {
        // your code is here
    }
}
```

2. In the `run()` method of `UsageMonitorTask`, simulate monitoring by printing the application name and sleeping for the specified delay period.

```java
@Override
public void run() {
    while (!Thread.interrupted()) {
        System.out.println("Monitoring internet usage for: " + appName);

        // Simulate monitoring by sleeping
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(appName + " monitoring interrupted.");
            break;
        }
    }
}
```

3. In the `main` method, create and start separate threads for each application. Use different delays to simulate the frequency of monitoring, with a shorter delay for Slack.

```java
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create tasks with different delays
        Runnable facebookTask = new UsageMonitorTask("Facebook", 3000);
        Runnable youtubeTask = new UsageMonitorTask("YouTube", 3000);
        Runnable whatsappTask = new UsageMonitorTask("WhatsApp", 3000);
        Runnable slackTask = new UsageMonitorTask("Slack", 1000); // Shorter delay for Slack

        // Create threads for the tasks
        Thread facebookThread = new Thread(facebookTask);
        Thread youtubeThread = new Thread(youtubeTask);
        Thread whatsappThread = new Thread(whatsappTask);
        Thread slackThread = new Thread(slackTask);

        // Start the threads
        // your code is here

        // Let the tasks run for a certain amount of time (e.g., 30 seconds)
        // your code is here

        // Interrupt the tasks, simulating a shutdown or cancellation
        // your code is here

        // Wait for all threads to finish
        // your code is here

        // All tasks are complete
        System.out.println("Internet usage monitoring tasks have been completed.");
    }
}
```

## Tips and Notes
- Use `Thread.sleep()` to simulate time delays.
- Remember to handle `InterruptedException` in your `run()` method.
- Adjust the delay for each application to simulate the frequency of monitoring. Slack should have the shortest delay to reflect its heavy usage.
- Use `Thread.interrupt()` to stop the threads after the monitoring duration has elapsed.
- Use `Thread.join()` to wait for all threads to finish before exiting the main method.

## Bonus Task
- Implement a shared resource (e.g., a `UsageStats` object) that all threads update with the amount of data used by each application. Synchronize access to this shared resource to prevent race conditions.
