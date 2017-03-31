import java.util.Map;

public class Planete extends Astres{



	public Planete(String name) {
		this.setAstres("planete");
		this.setCritere(name);
		Map<String, String> donnee = this.getXML();
		this.set$_type(donnee.get("type"));
		this.set$_nom(donnee.get("name"));
		this.set$_description(donnee.get("desc"));
	}



	public String toString(){
		return "Je suis la planète "+this.get$_nom()+" et je suis "+this.get$_type()+"\n"+this.get$_description();
	}

}
