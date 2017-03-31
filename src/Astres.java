
public class Astres extends ImportInfo {
	private String $_type;
	public Astres() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected String $_nom;
	//protected String $_img;
	protected String $_description;

	public String get$_nom() {
		return $_nom;
	}

	public void set$_nom(String $_nom) {
		this.$_nom = $_nom;
	}

	public String get$_description() {
		return $_description;
	}

	public void set$_description(String $_description) {
		this.$_description = $_description;
	}

	public String get$_type() {
		return $_type;
	}

	public void set$_type(String $_type) {
		this.$_type = $_type;
	}


   public String toString(){
      String str = "Ce nœud astres contient des objets !";
      return str;
   }
}
