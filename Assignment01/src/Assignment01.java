import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Assignment01 {

	 public static void main(String [] args){
		 
		try {
			
			File inputfile=new File("People.xml");
			
			DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder=dbfactory.newDocumentBuilder();
			Document document=dbuilder.parse(inputfile);
			document.getDocumentElement().normalize();
			
			System.out.println("ROOT ELEMENT: "+document.getDocumentElement().getNodeName());
			
			NodeList nodeList=document.getElementsByTagName("person");
			Node node=nodeList.item(0); 
			
			System.out.println("CURRENT ELEMENT: "+node.getNodeName());
			
			Element element=(Element) node;
			
			System.out.println("\n ---ACCESS ELEMENTS BY NAME / ACCESS SUB ELEMENTS--\n");
			
			//ACCESS ELEMENTS BY NAME / ACCESS SUB ELEMENTS 
			System.out.println(element.getElementsByTagName("firstname").item(0).getTextContent());
			System.out.println(element.getElementsByTagName("lastname").item(0).getTextContent());

			System.out.println("\n ---ACCESS ATTRUBUTES OF ELEMENT--\n");
			
			//ACCESS ATTRIBUTES OF ELEMENT
			System.out.println("ID ATTRIBUTE: "+element.getAttribute("id"));
			
			System.out.println("\n ---ACCESS PARENT ELEMENT FROM SUB ELEMENT--\n");

			//ACCESS PARENT ELEMENT FROM SUB ELEMENT
			System.out.println("PARENT ELEMENT: "+element.getParentNode().getNodeName());
			
		   
		}
		
		catch(Exception ex){
			
			ex.printStackTrace();
		}
	 }
}
