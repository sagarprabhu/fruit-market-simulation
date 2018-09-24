import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;  
	
		class Option extends JPanel
		{	JButton b1;
			JButton b2;
			JLabel l;
			JPanel p;
			
		Option(JPanel parent){  
		p=parent;	
		l=new JLabel("WELCOME TO OUR FRUIT MARKET!");
		b1=new JButton("FARMER"); 
		b2=new JButton("CONSUMER");
		
		GridLayout g=new GridLayout(3,1);
		setLayout(g);
		
		add(l);
		add(b1);
		add(b2);
		
		setSize(1000,1000);  //inherited from java.awt.Window 
		setVisible(true);  
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)p.getLayout();
				cl.show(p, "FarmerInterface");
				
			}
		});
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)p.getLayout();
				cl.show(p, "ConsumerInterface");
				
			}
		});
		
		
		b1.addMouseListener(new MouseListener() {
			
			//@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			//@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			//@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				b1.setBackground(Color.white);
			}
			
			//@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				b1.setBackground(Color.green);
			}
			
			//@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		b2.addMouseListener(new MouseListener() {
			
			//@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			//@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			//@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				b2.setBackground(Color.white);
			}
			
			//@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				b2.setBackground(Color.green);
			}
			
			//@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		
		
		
		}  
		
		}  