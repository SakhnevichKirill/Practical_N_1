import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyForm extends JFrame{

    private JPanel mainPanel;
    private JPanel calcPanel;
    private JButton addButton;
    private JButton deductButton;
    private JButton multiplyButton;
    private JButton shareButton;
    private JButton rootButton;
    private JButton percentButton;
    private JButton totalButton;
    private JPanel scorePanel;
    private JTextArea inputArea;
    private JLabel outLabel;
    private JTextField textField1;
    private JLabel scoreLabel;


    public MyForm(){
        super("My calc");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

//
//        inputArea.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                char a = e.getKeyChar();
//                if (a == '+')
//                    System.out.println('+');
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });
//
//       addButton.addMouseListener(new MouseListener() {
//           @Override
//           public void mouseClicked(MouseEvent e) {
//
//           }
//
//           @Override
//           public void mousePressed(MouseEvent e) {
//
//           }
//
//           @Override
//           public void mouseReleased(MouseEvent e) {
//
//           }
//
//           @Override
//           public void mouseEntered(MouseEvent e) {
//
//           }
//
//           @Override
//           public void mouseExited(MouseEvent e) {
//
//           }
//       });
//
//
//       totalButton.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//
//
//                scoreLabel.setText("0 x 0");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//
//            }
//        });

    }

    public static void main(String[] args) {

        MyForm myForm = new MyForm();
        myForm.setVisible(true);
        myForm.setLocationRelativeTo(null);
//        setSize(500, 500);

    }

    JPanel getMainPanel() {return mainPanel;}


}
