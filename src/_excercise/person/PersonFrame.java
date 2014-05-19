package _excercise.person;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonFrame extends JFrame {

  private static final long serialVersionUID = 1L;

  private DefaultListModel<PersonModel> model = new DefaultListModel<PersonModel>();
  private JList<PersonModel> list = new JList<PersonModel>(model);

  private JButton btnEN, btnDE, btnFR, btnADD;

  private JTextField txtFirstname, txtLastname, txtCity, txtCountry;

  public PersonFrame(String t) {
    super(t);

    Dimension dim = new Dimension(300, 300);
    list.setPreferredSize(dim);

    setLocation(100, 100);
    getContentPane().setLayout(new FlowLayout());
    setSize(400, 600);

    createGUI();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private Component getMenuPanel() {
    JPanel pnlMenu = new JPanel();
    pnlMenu.setLayout(new FlowLayout());
    btnDE = new JButton("DE");
    btnFR = new JButton("FR");
    btnEN = new JButton("EN");

    pnlMenu.add(btnDE);
    pnlMenu.add(btnFR);
    pnlMenu.add(btnEN);

    pnlMenu.setPreferredSize(new Dimension(300, 50));

    return pnlMenu;
  }

  private Component getInputPanel() {
    JPanel pnlInput = new JPanel();
    pnlInput.setLayout(new GridLayout(5, 2));
    txtFirstname = new JTextField();
    txtLastname = new JTextField();
    txtCity = new JTextField();
    txtCountry = new JTextField();

    JLabel lblFirstname = new JLabel("Firstname:");
    JLabel lblLastname = new JLabel("Lastname:");
    JLabel lblCity = new JLabel("City:");
    JLabel lblCountry = new JLabel("Country:");

    btnADD = new JButton("ADD");

    pnlInput.add(lblFirstname);
    pnlInput.add(txtFirstname);
    pnlInput.add(lblLastname);
    pnlInput.add(txtLastname);
    pnlInput.add(lblCity);
    pnlInput.add(txtCity);
    pnlInput.add(lblCountry);
    pnlInput.add(txtCountry);
    pnlInput.add(btnADD);

    pnlInput.setPreferredSize(new Dimension(300, 100));

    return pnlInput;
  }

  public void createGUI() {
    getContentPane().add(getMenuPanel());
    getContentPane().add(getInputPanel());
    getContentPane().add(list);

    btnADD.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        PersonModel p = new PersonModel(txtFirstname.getText(),
                                        txtLastname.getText(), 
                                        txtCity.getText(), 
                                        txtCountry.getText());
        model.addElement(p);
      }
    });
    
    list.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e){
        model.remove(list.getSelectedIndex());
      }
    });
  }
}
