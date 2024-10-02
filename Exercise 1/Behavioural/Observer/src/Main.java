// Main.java
public class Main {
    public static void main(String[] args) {
        Post post = new Post("001", "This is a clean post");

        ProfanityDetectionService profanityService = new ProfanityDetectionService();
        ImageModerationService imageModerationService = new ImageModerationService();

        post.addObserver(profanityService);
        post.addObserver(imageModerationService);

        // Edit content to trigger moderation services
        System.out.println("Updating post content...");
        post.editContent("This post contains a badword");

        // You can also extend this to more services like SpamDetectionService, UserReportingService, etc.
    }
}
