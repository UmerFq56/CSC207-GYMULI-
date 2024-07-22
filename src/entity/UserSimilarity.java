package entity;

public class UserSimilarity {
    /**
     * calculates the similarity score between two users
     */
    private final String username;
    private final double score;

    public UserSimilarity(String username, double score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public double getScore() {
        return score;
    }
}