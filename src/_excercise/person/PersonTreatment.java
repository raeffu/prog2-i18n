package _excercise.person;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PersonTreatment extends JFrame {

  public PersonTreatment() {
    createGUI();
  }

  private void createGUI() {
    JPanel pnlMenu = new JPanel();
    pnlMenu.setLayout(new FlowLayout());
    JButton btnDE = new JButton("DE");
    JButton btnFR = new JButton("FR");
    JButton btnEN = new JButton("EN");
    pnlMenu.add(btnEN);
    pnlMenu.add(btnDE);
    pnlMenu.add(btnFR);
    
    getContentPane().add(pnlMenu, BorderLayout.CENTER);

    JPanel pnlInput = new JPanel();
    pnlInput.setLayout(new GridLayout(5, 2));

    JPanel pnlOutput = new JPanel();
    pnlOutput.setLayout(new FlowLayout());
    
  }

  public static void main(String[] args) {
    new PersonTreatment();
  }
}
