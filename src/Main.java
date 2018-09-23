import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Terrain extends JPanel {
	int width,height,rows, cols;
	ImageIcon img;
	Terrain(int w, int h, int r, int c,ImageIcon image) {
		width=w;
		height=h;
		rows = r;
		cols = c;
		int rowHt = height / (rows);
		int rowWid = width / (cols);
		Image newImg = image.getImage().getScaledInstance(rowWid, rowHt, Image.SCALE_DEFAULT);
		img= new ImageIcon(newImg);
	}

  public void paintGround() {
	  setLayout(new GridLayout(cols,rows));
	  int i;
	  for(i=0;i<cols*rows;i++) {
			JLabel label = new JLabel();
			add(label);
			//label.setBorder(LineBorder.createBlackLineBorder());
			label.setIcon(img);
		}
  }
  
  public void paintRessource(ImageIcon img) {
	  //setLayout(new GridLayout(cols,rows));
	  //removeAll();
	  int random = (int)(Math.random()*cols*rows);
	  JLabel label = new JLabel();
	  label.setIcon(img);
	  add(label,random);

  }
}


public class Main extends JFrame{
	
	public static void main(String[] args) {
		showGUI();
	}
	
	private static void showGUI() {
		JFrame frame = new JFrame("StarCraft");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		ImageIcon imgGround = new ImageIcon("image\\ground.jpeg");
		
		Terrain terrain = new Terrain(800, 800, 10, 10,imgGround);
		terrain.paintGround();
		initRss(terrain);
		//frame.setPreferredSize(terrain.getSize());
		frame.setContentPane(terrain);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public static void initRss(Terrain terrain) {
		ImageIcon imgRss=new ImageIcon("image\\mineral.png");
		ImageIcon imgCtr=new ImageIcon("image\\center.png");
		for(int i =0 ;i<4;i++) {
			if(i==3)
				terrain.paintRessource(imgCtr);
			else
				terrain.paintRessource(imgRss);
		}
	}

	
}
