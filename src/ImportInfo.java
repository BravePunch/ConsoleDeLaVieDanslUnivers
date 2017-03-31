import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class ImportInfo {

	DocumentBuilderFactory factory ;
	DocumentBuilder builder;
	File fileXML;
	// parsing de notre fichier via un objet File et récupération d'un
    // objet Document
    // Ce dernier représente la hiérarchie d'objet créée pendant le parsing
    Document xml;
    String astres;
    String critere;


    public String getAstres() {
		return astres;
	}
	public void setAstres(String astres) {
		this.astres = astres;
	}
	public String getCritere() {
		return critere;
	}
	public void setCritere(String critere) {
		this.critere = critere;
	}

	public ImportInfo(){

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			fileXML = new File("infosastres.xml");
			xml = builder.parse(fileXML);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//
//	public String getRacine(){
//		// Via notre objet Document, nous pouvons récupérer un objet Element
//        // Ce dernier représente un élément XML mais, avec la méthode ci-dessous,
//        // cet élément sera la racine du document
//		Element racine = xml.getDocumentElement();
//        return racine.getNodeName();
//	}

	public Map<String, String> getXML(){
		// Via notre objet Document, nous pouvons récupérer un objet Element
        // Ce dernier représente un élément XML mais, avec la méthode ci-dessous,
        // cet élément sera la racine du document
		NodeList elem = xml.getElementsByTagName(astres);
		String toTest = "";
		String start = "";
		Map<String, String> ReturnList = new HashMap<String, String>();
		String type = "";
		String name = "";
		String desc = "";

		for(int i=0; i<elem.getLength(); i++) {

			NamedNodeMap attributes = elem.item(i).getAttributes();
			desc = elem.item(i).getTextContent();
			//System.out.println(attributes.getNamedItem("type").);
			type = attributes.getNamedItem("type").getTextContent();
			name = attributes.getNamedItem("name").getTextContent();

			if(astres.equals("etoile")){
				toTest = type;
			}

			if(astres.equals("planete")){
				toTest = name;
			}

			if(toTest.equals(critere)){
				ReturnList.put("type", type);
				ReturnList.put("name", name);
				ReturnList.put("desc", desc);
			}

		}


		//
        return ReturnList;
	}

}
