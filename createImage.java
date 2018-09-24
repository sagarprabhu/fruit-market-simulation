import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class createImage extends JPanel{

	String s;
public createImage(String s)
{
	this.s=s;

}
@Override
public void paintComponent(Graphics g) 
{
      BufferedImage image = null; // get your buffered image.
      try
      {
        image = ImageIO.read(new File(s));
      }
      catch (Exception e)
      {
        e.printStackTrace();
        System.exit(1);
      }
      Graphics2D graphics2d = (Graphics2D) g;
      graphics2d.drawImage(image, 0, 0, null);
      super.paintComponents(g);
  }

}