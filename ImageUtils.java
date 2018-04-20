import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.imageio.IIOException;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * All necessary utilities for displaying images, and converting between
 * 2D arrays and BufferedImages.
 * 
 * 
 * @author Benjamin Smith
 * @coauthor Samuel Price
 * @since 2018-03-18
 */
public class ImageUtils extends JPanel
implements ActionListener {
	int x=9;
	int y=8;
	int decision=0;
	protected JButton b1;
  // Frame to display on screen.
  private JFrame frame;
  // Tabbed panes to switch between
  static JTabbedPane tabbedPane;
  /**
   * Constructor sets up the frame and pane to add to.
   */
  ImageUtils() {
    // Create a new frame to display on screen.
    frame = new JFrame("Project Images");
    // The exit application default window close operation.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set up TabbedPanes to switch between images.
    tabbedPane = new JTabbedPane();
    // Set the Content pane
    frame.setContentPane(tabbedPane);
  }
  /**
   * Loads in a 2D Color array (an image) from the specified filepath.
   * @param filepath to the image.
   * @return the 2D Color array.
   */
  public Color[][] loadImage(String filepath) {
    // Load in the image.
	Color[][] colorImg=null;

    BufferedImage buffImg = loadBufferedImage(filepath);
    // Convert that image to the 2D array of colors and return it.
    colorImg = convertTo2DFromBuffered(buffImg);
	
    return colorImg;
  }
  /**
   * Adds a tab to the frame which displays a given image.
   * @param img the image to be displayed on the tab.
   * @param tabName the name to be given to the tab.
   */
  public void addImage(Color[][] img, String tabName) {
    // Convert the 2D Color array to BufferedImage
	  BufferedImage buffImg = convertToBufferedFrom2D(img);
    // Create icon for the image itself.
	  ImageIcon icon = new ImageIcon(buffImg);
	  icon.getImage().flush();
    // Create icon to be displayed on the tab, scaled to 32x32.
	  ImageIcon tabIcon = new ImageIcon(
        buffImg.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
    // Create a label, and add the icon to it.
	  JLabel label = new JLabel();
	  label.setIcon(icon);
    // Add the tab to the pane.
	  tabbedPane.addTab(tabName, tabIcon, label);
  }
//Tracks the mouse clicks on the Menu Items
  public void actionPerformed(ActionEvent e) {
      JMenuItem source = (JMenuItem)(e.getSource());
      String item=source.getText();
      	if(item.equals("Gray")){
    	  decision=1;
      	}if(item.equals("Cyanotype")){
    	  decision=2;
      	}if(item.equals("Sephia")){
    	  decision=3;
      	}if(item.equals("Green")){
    	  decision=4;
      	}if(item.equals("Rotate90")){
    	  decision=5;
      	}if(item.equals("Rotate180")){
    	  decision=6;
      	}if(item.equals("Rotate270")){
    	  decision=7;
      	}
  }
  //Returns the JFrame to manipulate Later and creates the save menu
  public void display(Color [][] original) {
	  JMenuBar jMenuBar = new JMenuBar();
	  JMenu jMenu1 = new JMenu("Save");
	  //Menu Items
	  		JMenuItem ItemGray = new JMenuItem("Gray");
	  			ItemGray.addActionListener(this);
	  				jMenu1.add(ItemGray);
	  		JMenuItem ItemCyan = new JMenuItem("Cyanotype");
	  			ItemCyan.addActionListener(this);
	  				jMenu1.add(ItemCyan);
	  		JMenuItem ItemSephia = new JMenuItem("Sephia");
	  			ItemSephia.addActionListener(this);
	  				jMenu1.add(ItemSephia);
	  		JMenuItem ItemGreen = new JMenuItem("Green");
	  			ItemGreen.addActionListener(this);
	  				jMenu1.add(ItemGreen);
	  				JMenuItem Item90 = new JMenuItem("Rotate90");
		  			Item90.addActionListener(this);
		  				jMenu1.add(Item90);
		  		JMenuItem Item180 = new JMenuItem("Rotate180");
		  			Item180.addActionListener(this);
		  				jMenu1.add(Item180);
		  		JMenuItem Item270 = new JMenuItem("Rotate270");
		  			Item270.addActionListener(this);
		  				jMenu1.add(Item270);
	  jMenuBar.add(jMenu1);
	  frame.setJMenuBar(jMenuBar);
	  frame.pack();
	    // Sets the size of the frame to the preferred size of the images.
	    frame.setSize(frame.getPreferredSize());
	    frame.setVisible(true);
  }
//Clones the inputed color array
  public static Color[][] cloneArray(Color[][] orig) {
    // Create array that is the copy
    Color[][] copy = new Color[orig.length][orig[0].length];
    // Go through each value copying it over.
    for (int i = 0; i < orig.length; i++) {
      for (int j = 0; j < orig[i].length; j++) {
        copy[i][j] = orig[i][j];
      }
    }
    // Return the copy.
    return copy;
  }

  private static BufferedImage loadBufferedImage(String filepath) {
    // A BufferedImage initialization.
    BufferedImage img = null;

    // Try to read an image from the specified path.
    try {
      // Read the (image) File the path directs to.
      img = ImageIO.read(new File(filepath));
    	} catch (IOException e) {
    		System.out.println("Could not load the image, please ensure the filepath"
    				+ " was properly specified.");
    		System.exit(1);
    }
    // Return the BufferedImage. If nothing was read, img contains NULL.
    return img;
  }
//Converts inputed 2D Color Array into a Buffered Image
  public static BufferedImage convertToBufferedFrom2D(Color[][] img) {
    // Create new BufferedImage of specified width and height
    int width = img.length;
    int height = img[0].length;
    BufferedImage bufImg = new BufferedImage(width, height, 1);

    // Set the RGB value of each pixel in the BufferedImage
    for (int x = 0; x < width; x++) {
      for(int y = 0; y < height; y++) {
        bufImg.setRGB(x,  y, img[x][y].getRGB());
      }
    }
    // Return the BufferedImage
    return bufImg;
  }
  /**
   * Converts a BufferedImage to a multidem array of Colors
   * @param img the BufferedImage to convert
   * @return the 2d array of Colors
   */
  private static Color[][] convertTo2DFromBuffered(BufferedImage img) {
    // Get width and height to make new 2d array
    int width = img.getWidth();
    int height = img.getHeight();
    Color[][] result = new Color[width][height];

    // Iterate through the array, adding new Colors from the intRGB values.
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        // Get the integer RGB, and separate it into individual components.
        // (BufferedImage saves RGB as a single integer value).
        int intRGB = img.getRGB(col, row);
        int red = (intRGB >> 16)&255;
        int green = (intRGB >> 8)&255;
        int blue = intRGB&255;
        // Set the pixel to the Color.
        result[col][row] = new Color(red, green, blue);
      }
    }
    // Return array
    return result;
  }
}