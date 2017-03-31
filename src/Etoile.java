import java.util.Map;

public class Etoile extends Astres {

	public Etoile(String $_type) {
		this.setAstres("etoile");
		this.setCritere($_type);
		Map<String, String> donnee = this.getXML();
		this.set$_type(donnee.get("type"));
		this.set$_nom(donnee.get("name"));
		this.set$_description(donnee.get("desc"));
	}

	public String toString(){
		return "Je suis une étoile "+this.get$_nom()+" et je suis "+this.get$_type()+"\n"+this.get$_description();
	}

}
