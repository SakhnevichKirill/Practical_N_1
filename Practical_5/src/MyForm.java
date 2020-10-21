import javax.swing.*;
import java.awt.event.*;

public class MyForm extends JFrame{

    private JPanel panel1;
    private JButton team1Button;
    private JButton team2Button;
    private JLabel team1Label;
    private JLabel team2Label;
    private JButton totalButton;
    private JLabel scoreLabel;

    public MyForm(Team team1, Team team2) {
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(panel1);

        scoreLabel.setText("0 x 0");

        team1Label.setText(team1.getName());
        team2Label.setText(team2.getName());

        team1Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                team1.increaseScore();
                scoreLabel.setText(team1.getScore() + " " + "x" + " " + team2.getScore());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        team2Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                team2.increaseScore();
                scoreLabel.setText(String.valueOf(team1.getScore()) + " " + "x" + " " + String.valueOf(team2.getScore()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        totalButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (team1.getScore() > team2.getScore()) {
                    JOptionPane.showMessageDialog(MyForm.this, "Team " + team1.getName() + " won!");
                } else if (team1.getScore() < team2.getScore()) {
                    JOptionPane.showMessageDialog(MyForm.this, "Team " + team2.getName() + " won!");
                }
                else {
                    JOptionPane.showMessageDialog(MyForm.this, "DRAW");
                }
                team1.setScore(0);
                team2.setScore(0);
                scoreLabel.setText("0 x 0");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {


            }
        });
    }
}