class UsageMonitorTask implements Runnable {
    private String appName;
    private int delay;
    private UsageStats usageStats;

    public UsageMonitorTask(String appName, int delay, UsageStats usageStats) {
        this.appName = appName;
        this.delay = delay;
        this.usageStats = usageStats;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Monitoring internet usage for: " + appName);

                // Simulate data usage
                int dataUsage = (int) (Math.random() * 10) + 1; // Simulate random data usage
                usageStats.updateDataUsage(appName, dataUsage);

                // Simulate monitoring by sleeping
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println(appName + " monitoring interrupted.");
        }
    }
}
