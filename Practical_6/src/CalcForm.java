import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalcForm extends JFrame{
    private JPanel mainPanel;
    private JList historyList;
    private JButton buttonReset;
    private JButton button7;
    private JButton button4;
    private JButton button1;
    private JButton buttonE;
    private JButton button8;
    private JButton button5;
    private JButton button2;
    private JButton buttonPercent;
    private JButton button9;
    private JButton button6;
    private JButton button3;
    private JButton buttonDivide;
    private JButton buttonMultiply;
    private JButton buttonSubtract;
    private JButton buttonAdd;
    private JButton buttonEqually;
    private JButton button0;
    private JButton buttonSeparator;
    private JTextField textInput;
    private JPanel inputPanel;
    private JPanel historyPanel;
    private JButton buttonCleanHistory;
    private JPanel calcPanel;
    private JLabel labelResult;

    private ArrayList<Calc> result;
    private DefaultListModel listCalcModel;

    public CalcForm() {
        super("My calc");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 700);

        result = new ArrayList<Calc>();
        listCalcModel = new DefaultListModel();
        historyList.setModel(listCalcModel);

        buttonCleanHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.clear();
                refreshCalcList();
            }
        });

        historyList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int historyNumber = historyList.getSelectedIndex();
                if (historyNumber >= 0){
                    Calc c = result.get(historyNumber);
                    textInput.setText(c.getRecord());
                    labelResult.setText(c.getResult());

                    buttonEqually.setEnabled(true);
                }
                else {
                    buttonEqually.setEnabled(false);
                }
            }
        });


        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int historyNumber = historyList.getSelectedIndex();
                if (historyNumber >= 0){
//                    Calc c = result.get(historyNumber);
//                    c.setRecord("");
                    result.remove(historyNumber);
                    refreshCalcList();
                }
            }
        });
        buttonEqually.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calc c = new Calc(textInput.getText());
                result.add(c);
                refreshCalcList();
                textInput.setText(c.getRecord());
                labelResult.setText(c.getResult());

            }
        });
        buttonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "e");
            }
        });
        buttonPercent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "%");
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "/");
            }
        });
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "x");
            }
        });
        buttonSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "-");
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "+");
            }
        });
        buttonSeparator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + ".");
            }
        });
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textInput.getText() + "9");
            }
        });
    }

    public void refreshCalcList() {
        listCalcModel.removeAllElements();
        System.out.println("Removing all people from list");
        for (Calc c : result) {
            System.out.println("Adding record of calculation: " + c.getRecord());
            listCalcModel.addElement(c.getRecord());
        }
    }

    public void addResult(Calc c){
        result.add(c);
        refreshCalcList();
    }


    public static void main(String[] args) {
        CalcForm calcForm = new CalcForm();
        calcForm.setVisible(true);

        Calc first = new Calc("1+2+33x4/5xe");
        Calc second = new Calc("1+2x15%");
        Calc third = new Calc("5+2f9");
        Calc fourth = new Calc("5+2x8%6");

        calcForm.addResult(first);
        calcForm.addResult(second);
        calcForm.addResult(third);
        calcForm.addResult(fourth);

//        myForm.setLocationRelativeTo(null);
    }

}
