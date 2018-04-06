import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
public class Test1 extends JFrame implements MouseListener, MouseMotionListener
{
  static int red;
  static int blue;
  static int green;
  static int x1;
  static int y1;
  public Test1()
  {
    addMouseListener(this);
    addMouseMotionListener(this);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void mousePressed(MouseEvent e)
  {
    x1 = e.getX();
    y1 = e.getY();
  }
  public static void Locator(String filename){
	  
	ImageUtils image=new ImageUtils();
	Color[][] original = image.loadImage(filename);
	BufferedImage im=image.convertToBufferedFrom2D(original);
	
    Test1 picture=new Test1();
    picture.setContentPane(new JLabel(new ImageIcon(im)));
    picture.setSize(picture.getPreferredSize());
    picture.pack();
    while(x1==0) {
    picture.setVisible(true);
    }
    picture.setVisible(false);
    red=original[x1][y1].getRed();
    blue=original[x1][y1].getBlue();
    green=original[x1][y1].getGreen();
  }
  public static void ReplaceColor(String filename) {
	    Locator(filename);
	    ImageUtils image=new ImageUtils();
	    Color[][]  original= image.loadImage(filename);
	    Color[][] colors=image.loadImage("Colors.png");
		BufferedImage imag=image.convertToBufferedFrom2D(colors);
	  x1=0;
	    Test1 colorful=new Test1();
	    colorful.setContentPane(new JLabel(new ImageIcon(imag)));
	    colorful.setSize(colorful.getPreferredSize());
	    colorful.pack();
	    while(x1==0) {
	    	colorful.setVisible(true);
	    }
	    colorful.setVisible(false);
	    int red1=colors[x1][y1].getRed();
	    int blue1=colors[x1][y1].getBlue();
	    int green1=colors[x1][y1].getGreen();
	    for (int i=0; i<original.length; i++) {
	    	for(int j=0; j<original[0].length; j++) {
	    		boolean redless=((red)>=original[i][j].getRed()-2);
	    		boolean redmore=((red)<=original[i][j].getRed()+2);
	    		boolean blueless=((blue)>=original[i][j].getBlue()-2);
	    		boolean bluemore=((blue)<=original[i][j].getBlue()+2);
	    		boolean greenless=((green)>=original[i][j].getGreen()-2);
	    		boolean greenmore=((green)<=original[i][j].getGreen()+2);
	    		if((redless&&redmore)||(blueless&&bluemore)||(greenless&&greenmore)) {
	    				original[i][j]=new Color(red1,green1,blue1);
	    				}
	      }
	    }
	    BufferedImage ima=image.convertToBufferedFrom2D(original);
	    Test1 Recolored=new Test1();
	    Recolored.setContentPane(new JLabel(new ImageIcon(ima)));
	    Recolored.setSize(colorful.getPreferredSize());
	    Recolored.pack();
	    Recolored.setVisible(true);
  }
  
//Overrides for MouseListener
  	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}