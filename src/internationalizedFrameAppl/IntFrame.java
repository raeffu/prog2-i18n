package internationalizedFrameAppl;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public final class IntFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int W=400, H=400;
	private JLabel laFirstName, laLastName, laCity, laCountry;
	private JTextField tfFirstName, tfLastName, tfCity, tfCountry;
	private JButton buAdd,buEN, buGE, buFR;
	
	private Locale locale;
	private ResourceBundle rb;
	private PersonStore<Person> personStore = new PersonStore<Person>();
	private DefaultListModel<Person> listModel = new DefaultListModel<Person>();
	private JList<Person> list = new JList<Person>(listModel);
	private JScrollPane listScrollPane = new JScrollPane(list);
	
	public IntFrame(String t){
		super(t);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(W, H);
		initializeGraphicCompoonents();	
		this.setLayout(new FlowLayout());
		this.add(getButtonPane());
		this.add(getInfoGetterPane());
		this.add(getPersonDisplayPane());
		this.setVisible(true);
	}

	private JComponent getPersonDisplayPane() {
		Dimension dim = new Dimension(W-20,180);
		JPanel pan = new JPanel();
		listScrollPane.setPreferredSize(dim);
		pan.add(listScrollPane);
		return pan;
	}

	private JComponent getButtonPane() {
		JPanel pan = new JPanel();
		Dimension dim = new Dimension(W-20,30);
		pan.setSize(dim);
		pan.setLayout(new FlowLayout());
		pan.add(buAdd);
		pan.add(buEN);
		pan.add(buGE);
		pan.add(buFR);
		return pan;	
	}
	
	private JComponent getInfoGetterPane() {
		JPanel pan = new JPanel();
		Dimension dim = new Dimension(W-20,100);
		pan.setPreferredSize(dim);
		pan.setLayout(new GridLayout(5,2));
		pan.add(laFirstName);
		pan.add(tfFirstName);
		pan.add(laLastName);
		pan.add(tfLastName);
		pan.add(laCity);
		pan.add(tfCity);
		pan.add(laCountry);
		pan.add(tfCountry);
		pan.add(buAdd);
		return pan;	
	}

	private void initializeGraphicCompoonents() {
		Dimension dim = new Dimension(20,10);
		laFirstName = new JLabel();
		laLastName = new JLabel();
		laCity = new JLabel();
		laCountry = new JLabel();
		tfFirstName = new JTextField();
		tfLastName = new JTextField();
		tfCity = new JTextField();
		tfCountry = new JTextField();
		tfFirstName.setPreferredSize(dim);
		tfLastName.setPreferredSize(dim);
		tfCity.setPreferredSize(dim);
		tfCountry.setPreferredSize(dim);
		buAdd= new JButton("ADD");
		buEN= new JButton("EN");
		buGE= new JButton("GE");
		buFR= new JButton("FR");
		setLanguage("de", "CH");
        list.setSelectedIndex(0);
        list.setVisibleRowCount(11);
		buAdd.addActionListener(new ActionListener(){@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			Person p = new Person(tfFirstName.getText(),tfLastName.getText(),tfCity.getText(), tfCountry.getText());
			personStore.add(p);
			Collections.sort(personStore);
			System.out.println(personStore);
			refreshListModel(personStore);
		}});
		buEN.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {setLanguage("en", "US");}});
		buGE.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {setLanguage("de", "CH");}});
		buFR.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {setLanguage("fr", "FR");}});
	}
	
	private void refreshListModel(PersonStore<Person> personStore){
		listModel.clear();
		for(Person p: personStore) listModel.addElement(p);
	}
	
	private void setLanguage(String language, String country){
		locale = new Locale(language, country);
		rb = ResourceBundle.getBundle("IntFrameSample", locale);
		laFirstName.setText(rb.getString("FirstName"));
		laLastName.setText(rb.getString("LastName"));
		laCity.setText(rb.getString("City"));
		laCountry.setText(rb.getString("Country"));
	}
}
