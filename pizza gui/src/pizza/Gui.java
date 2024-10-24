package pizza;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Gui extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JComboBox comboBoxpizza;
	private JComboBox comboBoxExtra;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_gesamtpreis;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_preis;
	private JLabel lblNewLabel_6;
	private JComboBox comboBoxGrose;
	private DefaultListModel<Wahrenkorb> dlm2 = new DefaultListModel<>();
	private DefaultComboBoxModel<Pizza> dlm1 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Extra> dlm3 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Grose> dlm4 = new DefaultComboBoxModel<>();
	Pizza Salami = new Pizza("Salami");
	Pizza Schinken = new Pizza("Schinken");
	Pizza Pizzabrot = new Pizza("Pizzabrot");
	Extra nichts = new Extra("nix",0);
	Extra Pommes = new Extra("Pommes",1);
	Extra Schnizel = new Extra("Schnizel",5);
	Extra Salat = new Extra("Salat",3);
	Grose klein = new Grose("klein",6);
	Grose gros = new Grose("Groß",8);
	Grose mittel = new Grose("Mittel",12);
	private JList listPizza;
	private double gesamt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui()
	{
		initialize();
		erzeugen();
		preis();
		gesamt();
		listPizza.setModel(dlm2);
		
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getComboBox());
		contentPane.add(getComboBox_1());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_gesamtpreis());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_preis());
		contentPane.add(getLblNewLabel_6());
		contentPane.add(getComboBox_2());
		contentPane.add(getListPizza());
		
		
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Pizza");
			lblNewLabel.setBounds(28, 11, 46, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Extras");
			lblNewLabel_1.setBounds(28, 44, 46, 14);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Hinzufügen");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {hinzufugen();
				}
			});
			btnNewButton.setBounds(279, 93, 89, 23);
		}
		return btnNewButton;
	}
	private JComboBox getComboBox() {
		if (comboBoxpizza == null) {
			comboBoxpizza = new JComboBox();
			comboBoxpizza.setBounds(99, 7, 89, 22);
		}
		return comboBoxpizza;
	}
	private JComboBox getComboBox_1() {
		if (comboBoxExtra == null) {
			comboBoxExtra = new JComboBox();
			comboBoxExtra.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {preis();
				}
			});
			comboBoxExtra.setBounds(99, 40, 89, 22);
		}
		return comboBoxExtra;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Entfernen");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {entfernen();
				}
			});
			btnNewButton_1.setBounds(279, 137, 89, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Bestellen");
			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {gesamt();
				}
			});
			btnNewButton_2.setBounds(279, 171, 89, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Gesamtpreis");
			lblNewLabel_2.setBounds(28, 236, 73, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_gesamtpreis() {
		if (lblNewLabel_gesamtpreis == null) {
			lblNewLabel_gesamtpreis = new JLabel("");
			lblNewLabel_gesamtpreis.setBounds(322, 236, 46, 14);
		}
		return lblNewLabel_gesamtpreis;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Preis");
			lblNewLabel_4.setBounds(223, 44, 46, 14);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_preis() {
		if (lblNewLabel_preis == null) {
			lblNewLabel_preis = new JLabel("");
			lblNewLabel_preis.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {preis();
				}
			});
			lblNewLabel_preis.setBounds(322, 44, 46, 14);
		}
		return lblNewLabel_preis;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Größe");
			lblNewLabel_6.setBounds(223, 11, 46, 14);
		}
		return lblNewLabel_6;
	}
	private JComboBox getComboBox_2() {
		if (comboBoxGrose == null) {
			comboBoxGrose = new JComboBox();
			comboBoxGrose.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					preis();
				}
			});
			comboBoxGrose.setBounds(279, 7, 89, 22);
		}
		return comboBoxGrose;
	}
	public void erzeugen()
	{
		comboBoxpizza.setModel(dlm1);
		//ArrayList<Pizza>pizzalist=new  ArrayList<Pizza>();
		
		
		dlm1.addElement(Schinken);
		dlm1.addElement(Salami);
		dlm1.addElement(Pizzabrot);
		comboBoxExtra.setModel(dlm3);
		dlm3.addElement(nichts);
		dlm3.addElement(Pommes);
		dlm3.addElement(Schnizel);
		dlm3.addElement(Salat);
		comboBoxGrose.setModel(dlm4);
		dlm4.addElement(klein);
		dlm4.addElement(gros);
		dlm4.addElement(mittel);
	
		
		
	}
	public void hinzufugen()
	{
		Wahrenkorb alles = new Wahrenkorb((Pizza)comboBoxpizza.getSelectedItem(),(Grose)comboBoxGrose.getSelectedItem(),(Extra)comboBoxExtra.getSelectedItem());
		dlm2.addElement(alles);
		double i = ((Extra)comboBoxExtra.getSelectedItem()).getPreis();
		double e = ((Grose)comboBoxGrose.getSelectedItem()).getPreis();
		gesamt = gesamt+e + i;
		//textArea.add(comboBox);
		//textArea.setModel(dlm2);
		
	}
	
	public void entfernen()
	{
		double i = ((Wahrenkorb)listPizza.getSelectedValue()).getGrose().getPreis();
		double e = ((Wahrenkorb)listPizza.getSelectedValue()).getExtra().getPreis();
		e=e+i;
		gesamt = gesamt -e;
		dlm2.removeElement(listPizza.getSelectedValue());
		
	}
	public void preis()
	{
		if(comboBoxGrose.getSelectedItem()!=null)
		{
			double i = ((Extra)comboBoxExtra.getSelectedItem()).getPreis();
			double e = ((Grose)comboBoxGrose.getSelectedItem()).getPreis();
			e = e + i;
			lblNewLabel_preis.setText(""+e);
		}
		else
		{
			lblNewLabel_preis.setText("0.00");
		}
	}
	
	public void gesamt()
	{
		lblNewLabel_gesamtpreis.setText(""+gesamt);
	}
	
	private JList getListPizza() {
		if (listPizza == null) {
			listPizza = new JList();
			listPizza.setBounds(28, 93, 237, 132);
		}
		return listPizza;
	}
}
