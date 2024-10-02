public class ProfanityDetectionService implements Observer {
    @Override
    public void update(Post post) {
        if (post.getContent().contains("badword")) {
            System.out.println("Profanity detected in post: " + post.getId());
            post.flagAsInappropriate();
        }
    }
}
