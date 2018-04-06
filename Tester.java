import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tester{

	public static void main(String[] args) {
		ImageUtils image=new ImageUtils();
		Editor edit=new Editor();
		Test1 mose=new Test1();
		
		int choice=10;
		String[] choices= new String[] {"Total Recoloring", "Color Replacer"};
		choice= JOptionPane.showOptionDialog(null, "Which do you want to perform", "Method",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, choices, choices[1]);
		
		String filename="background2.png";
		
		if(choice==0) {
		
		Color[][] original = image.loadImage(filename);
	    Color[][] gray = edit.Grayscale(original);
	    Color[][] cyanotype= edit.Cyanotype(original);
	    Color[][] sephia = edit.Sephia(original);
	    image.addImage(original, "Original");
	    image.addImage(gray, "Grayscale");
	    image.addImage(cyanotype, "Cyanotype");
	    image.addImage(sephia, "Sephia");
	    image.display();
		}if(choice==1) {
		mose.ReplaceColor(filename);
		
		}
		if(choice==10) {
			System.exit(1);
		}
	}
}