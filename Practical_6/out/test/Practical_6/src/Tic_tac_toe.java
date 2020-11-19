import javax.swing.*;

public class Tic_tac_toe extends JFrame{
    private JButton b7;
    private JPanel mainPanel;
    private JButton b4;
    private JButton b8;
    private JButton b5;
    private JButton b9;
    private JButton b6;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton bX;
    private JButton bO;


    public Tic_tac_toe(){
        super("My calc");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 700);

    }



    public static void main(String[] args) {
        Tic_tac_toe tic_tac_toe = new Tic_tac_toe();
        tic_tac_toe.setVisible(true);


//        myForm.setLocationRelativeTo(null);

    }
}
