public class ImageModerationService implements Observer {
    @Override
    public void update(Post post) {
        if (post.hasInappropriateImages()) {
            System.out.println("Inappropriate image detected in post: " + post.getId());
            post.flagAsInappropriate();
        }
    }
}