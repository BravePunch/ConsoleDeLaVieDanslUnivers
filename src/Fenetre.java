import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame {

	JSplitPane splitPan;
	JPanel imagesPan = new JPanel();
	JPanel boutonPan = new JPanel();

	// BOUTON
	JButton bouton = new JButton("sent ;)");

	public Fenetre(){
		//Définit un titre pour notre fenêtre
		this.setTitle("Console de la vie dans l'univers");
		//Définit sa taille : 800 pixels de large et 600 pixels de haut
	    this.setSize(800, 600);
	    //Nous demandons maintenant à notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //la fenetre est elle redimensionnable ?
	    this.setResizable(false);
	    // ou doit se trouver la fenetre sur l'écran
	    // les coordonnées x=0, y=0 représentent le coin supérieur gauche de l'écran
	    //this.setLocation(0, 0);
	    //garder la fenetre au premier plan :
	    //this.setAlwaysOnTop(true);




	    Etoile e1 = new Etoile("GeanteBleue");
	    Etoile e2 = new Etoile("GeanteRouge");
		Planete p1 = new Planete("Terre");

		DrawImages DI = new DrawImages();
		DI.addImages(e1);
		DI.addImages(e2);
		DI.addImages(p1);
	    //this.setContentPane(pan);
	    //On prévient notre JFrame que notre JPanel sera son content pane
		//pan.add(new DrawImages(p1.get$_type(), 20, 20));

		imagesPan.update(DI);
		boutonPan.add(bouton);
		boutonPan.setBackground(Color.LIGHT_GRAY);

		splitPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT, imagesPan, boutonPan);

		this.getContentPane().add(splitPan, BorderLayout.CENTER);

	    //Et enfin, la rendre visible
	    this.setVisible(true);
	}
}
