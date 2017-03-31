import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawImages extends JPanel {
//	private Image _img;
//	private int _posX;
//	private int _posY;

	private ArrayList<Image> images = new ArrayList<Image>();
	private ArrayList<String> titres = new ArrayList<String>();
	private ArrayList<String> description = new ArrayList<String>();

	/*public DrawImages(String nameImg, int x, int y){
		super();
		try {
			//System.out.println("img/"+nameImg+".png");
			this._img = ImageIO.read(new File("img/"+nameImg+".png"));
	 	} catch (IOException e) {
	      e.printStackTrace();
	    }
		if(x == -1 && y == -1){
	    	  this._posX = (this.getWidth() - this._img.getWidth(null))/2;
	    	  this._posY = (this.getHeight() - this._img.getHeight(null))/2;
	      }
		else {
			this._posX = x;
			this._posY = y;
		}
	}*/

	public void addImages(Astres astre){
		try {
			Image img = ImageIO.read(new File("img/"+astre.get$_type()+".png"));
			this.images.add(img);
			this.titres.add(astre.get$_nom());
			this.description.add(astre.get$_description());
		} catch (IOException e) {
	      e.printStackTrace();
	    }
		this.repaint();
	}


  public void paintComponent(Graphics g){
	//Random randomGenerator = new Random();
	Font font1 = new Font("Courier", Font.BOLD, 20);
	g.setFont(font1);
    g.setColor(Color.gray);
	int startX = 20;
	int startY = 20;
    for(int i = 0; i < this.images.size(); i++){
//    	int randomX = randomGenerator.nextInt(this.getWidth()-250);
//    	int randomY = randomGenerator.nextInt(this.getHeight()-250);
    	int posX = startX + i*250;
    	int posY = startY;

        g.drawString(this.titres.get(i), posX, posY);
    	g.drawImage(this.images.get(i), posX , posY+30, 200, 200, this);

    }
      //Pour une image de fond
      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

  }
}
