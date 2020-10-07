import javax.swing.*;

public class Loader {

    public static void main(String[] args) {
        Team team1 = new Team("BLACK");
        Team team2 = new Team("WHITE");
        new MyForm(team1, team2);
    }

}
