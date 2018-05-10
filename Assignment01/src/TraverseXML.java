import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TraverseXML {

	 public static void main(String [] args){
		 
       try {
			 
			 File inputfile=new File("People.xml");
			 
			 DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			 DocumentBuilder dbuilder=dbFactory.newDocumentBuilder();
			 Document document=dbuilder.parse(inputfile);
			 document.getDocumentElement().normalize();
			
			 System.out.println("Root Element: "+ document.getDocumentElement().getNodeName());
			 NodeList list=document.getElementsByTagName("person");		 
			 
			 for(int x=0; x<list.getLength(); x++){
				 
				 Node node=list.item(x);
				 
				 System.out.println("Current Element: "+node.getNodeName());
				 
				 
				 if(node.getNodeType()==Node.ELEMENT_NODE){
					 
					 Element e=(Element) node;
					 
					 System.out.println("ID ATTRIBUTE: "+e.getAttribute("id"));
					 System.out.println("FIRST NAME: "+e.getElementsByTagName("firstname").item(0).getTextContent());
					 System.out.println("LAST NAME: "+e.getElementsByTagName("lastname").item(0).getTextContent());
					 System.out.println("AGE: "+e.getElementsByTagName("age").item(0).getTextContent());
				 }
				 
				 System.out.println();
			 }
		 }
		 
		 catch(Exception ex){
			 
			 ex.printStackTrace();
		 }
	 }
}
