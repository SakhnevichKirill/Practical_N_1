public class Team {
    private int score;
    private String name;

    public Team(String name) {
        this.score = 0;
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore() {
        score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}