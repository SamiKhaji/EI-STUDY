// Post.java
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String id;
    private String content;
    private boolean inappropriate;
    private List<Observer> observers = new ArrayList<>();

    public Post(String id, String content) {
        this.id = id;
        this.content = content;
        this.inappropriate = false;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isInappropriate() {
        return inappropriate;
    }

    public void flagAsInappropriate() {
        this.inappropriate = true;
        System.out.println("Post " + id + " has been flagged as inappropriate.");
    }

    public boolean hasInappropriateImages() {
        // Simulate image moderation check (e.g., AI-based)
        return false; // Simulate no inappropriate image
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void editContent(String newContent) {
        this.content = newContent;
        notifyObservers();
    }
}
