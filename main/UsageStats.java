class UsageStats {
    private int facebookDataUsage;
    private int youtubeDataUsage;
    private int whatsappDataUsage;
    private int slackDataUsage;

    public synchronized void updateDataUsage(String appName, int amount) {
        switch (appName) {
            case "Facebook":
                facebookDataUsage += amount;
                break;
            case "YouTube":
                youtubeDataUsage += amount;
                break;
            case "WhatsApp":
                whatsappDataUsage += amount;
                break;
            case "Slack":
                slackDataUsage += amount;
                break;
            default:
                System.out.println("Unknown application: " + appName);
        }
    }

    public synchronized void printDataUsage() {
        System.out.println("Data Usage Statistics:");
        System.out.println("Facebook: " + facebookDataUsage + " MB");
        System.out.println("YouTube: " + youtubeDataUsage + " MB");
        System.out.println("WhatsApp: " + whatsappDataUsage + " MB");
        System.out.println("Slack: " + slackDataUsage + " MB");
    }
}

