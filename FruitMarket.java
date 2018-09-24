

import java.awt.*;
import java.util.Vector;

import javax.swing.*;


public class FruitMarket extends JFrame {
	static int c=0;
	

	FruitMarket(){
		
		Fruit fruits[]=new Fruit[4];
		fruits[0]=new Fruit("APPLE");
		fruits[1]=new Fruit("MANGO");
		fruits[2]=new Fruit("ORANGE");
		fruits[3]=new Fruit("BANANA");
	
		JPanel parentp = new JPanel();
		add(parentp);
		CardLayout cl = new CardLayout();
		parentp.setLayout(cl);

	    Option p1=new Option(parentp);
		Market p2=new Market(fruits,parentp);
		Vector<ConsumerInterface> v1=new Vector<ConsumerInterface>();
		Vector<FarmerInterface> v2=new Vector<FarmerInterface>();
		parentp.add("Option", p1);
 		parentp.add("Market", p2);
 		v2.add(new FarmerInterface(fruits, parentp));
 		v1.add(new ConsumerInterface(fruits, parentp));
		parentp.add("ConsumerInterface",v1.get(c) );
		parentp.add("FarmerInterface", v2.get(c));
		cl.show(parentp, "Option");
		c++;
	setSize(1000,1000);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FruitMarket();
        
	}

}
