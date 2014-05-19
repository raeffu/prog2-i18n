package swing.lists;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class ActionFrame extends JFrame implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model = new DefaultListModel<String>();	
	private JList<String> list = new JList<String>(model);
	private JTextField in = new JTextField();

	public ActionFrame(String s) {
		
		super(s);

		model.addElement("First");
		model.addElement("Second");
		model.addElement("Third");

		JPanel show = new JPanel();
		show.setLayout(new GridLayout(2,1));
		show.add(in);
		JButton addButton = new JButton("add");
		show.add(addButton);

		JScrollPane jsp = new JScrollPane(list);
		getContentPane().add(jsp, BorderLayout.SOUTH);
		getContentPane().add(show, BorderLayout.CENTER);
		pack();

		list.addMouseListener(this);
		addButton.addActionListener(this);
	}

	public void mouseClicked(MouseEvent arg0){model.remove(list.getSelectedIndex());}

	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}

	public void actionPerformed(ActionEvent arg0) {model.addElement(in.getText());}
}