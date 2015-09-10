package testXml.testDomRead;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * ref : http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
 * Created by yukai on 15-9-10.
 */
public class ReadXMLFileDom {
    public static void main(String argv[]) {
        try {
            File fXmlFile = new File("java_learn/src/main/resources/testXml/books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            traverseUseNode(doc);
            traverseUseElement(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用 Node 来遍历
     * 注意Node是有很多种类的,只有ELEMENT_NODE类型才是<tag></tag>这样的节点
     *
     * ref : http://www.w3schools.com/xml/dom_nodes.asp
     * According to the DOM, everything in an XML document is a node.
     *  The entire document is a document node
     *  Every XML element is an element node
     *  The text in the XML elements are text nodes
     *  Every attribute is an attribute node
     *  Comments are comment nodes
     */
    private static void traverseUseNode(Document doc){
        // 直接通过TagName获取NodeList,注意这里虽然是返回NodeList,但是只会返回ELEMENT_NODE类型的Node,从方法名就可以看出来
        // Node类型是没有这个方法的,但是Element类型有这个方法,所以转化为Element后就有这种好处的
        NodeList nList = doc.getElementsByTagName("bookstore");
        System.out.println("bookstore的个数:"+nList.getLength());
        Node rootNode = nList.item(0);
        if(rootNode.hasChildNodes()){
            System.out.println("bookstore的child node个数:"+rootNode.getChildNodes().getLength()+",类型分别为:"+printNodeType(rootNode.getChildNodes()));// 11个,包括text_node,element_node,等所有种类的node
            printNodeList(rootNode.getChildNodes());
        }
    }

    private static String printNodeType(NodeList nodeList){
        StringBuilder sb = new StringBuilder();
        sb.append("===[[[");
        for(int i=0;i<nodeList.getLength();i++){
            sb.append(nodeList.item(i).getNodeType() + ",");
        }
        sb.deleteCharAt(sb.length()-1).append("]]]===");
        return sb.toString();
    }

    private static void printNodeList(NodeList nodeList) {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("\nNode getNodeName =" + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node getTextContent =" + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {
                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        System.out.println("attr getNodeName : " + node.getNodeName());
                        System.out.println("attr getNodeValue : " + node.getNodeValue());
                    }
                }

                if (tempNode.hasChildNodes()) {
                    // loop again if has child nodes
                    System.out.println(tempNode.getNodeName()+"的child node个数:"+tempNode.getChildNodes().getLength()+",类型分别为:"+printNodeType(tempNode.getChildNodes()));
                    printNodeList(tempNode.getChildNodes());
                }
                System.out.println("Node getNodeName =" + tempNode.getNodeName() + " [CLOSE]");
            }
        }
    }

    /**
     * 使用 Element 来遍历
     * 注意:Element就是ELEMENT_NODE类型的Node,而且Element extends Node
     */
    private static void traverseUseElement(Document doc){
        // 直接通过TagName获取NodeList,注意这里虽然是返回NodeList,但是只会返回ELEMENT_NODE类型的Node,从方法名就可以看出来
        // Node类型是没有这个方法的,但是Element类型有这个方法,所以转化为Element后就有这种好处的
        NodeList nList = doc.getElementsByTagName("bookstore");
        System.out.println("bookstore的个数:"+nList.getLength());

        nList = doc.getElementsByTagName("book");
        System.out.println("book的个数:"+nList.getLength()+",类型分别为:"+printNodeType(nList));

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            System.out.println("\nCurrent NodeName :" + nNode.getNodeName() + ", NodeType:" + nNode.getNodeType());
            Element eElement = (Element) nNode;
            System.out.println("book attr[id]: " + eElement.getAttribute("id") + ", attr[category]:" + eElement.getAttribute("category"));
            System.out.println("title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
            if(eElement.getElementsByTagName("author").getLength()>1){
                for(int j=0;j<eElement.getElementsByTagName("author").getLength();j++){
                    System.out.println("author : " + eElement.getElementsByTagName("author").item(j).getTextContent());
                }
            }else{
                System.out.println("author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
            }
            System.out.println("year : " + eElement.getElementsByTagName("year").item(0).getTextContent());
            System.out.println("price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
        }
    }


}
