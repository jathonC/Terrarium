package com.company.model;
import com.company.Reptiles_package.Reptile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class Build_xml {
    public static void build(Terrarium terrarium){
        List<Reptile> reptilies1 = terrarium.getReptilies();
        int num_poison = 0;
        int num_no_poison = 0;
        int age_poison = 0;
        int age_no_poison = 0;
        for (int i = 0; i < reptilies1.size(); i++) {
            if (reptilies1.get(i).isPoisonous()) {
                age_poison += reptilies1.get(i).getAge();
                num_poison++;
            } else {
                num_no_poison++;
                age_no_poison += reptilies1.get(i).getAge();
            }
        }
        System.out.println("Ядовитые: " + num_poison + "\nСредний возраст: " + age_poison / num_poison
                + "\nНеядовитые: " + num_no_poison + "\nСредний возраст: " + age_no_poison / num_no_poison);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS("", "Terrarium");
            doc.appendChild(rootElement);
            String name = terrarium.getName();
            Element poisonous = doc.createElement("name");
            poisonous.appendChild(doc.createTextNode(name));
            rootElement.appendChild(poisonous);
            rootElement.appendChild(getNote_poison(doc, "" + num_poison, "" + age_poison));
            rootElement.appendChild(getNote_no_poison(doc, "" + num_no_poison, "" + age_no_poison));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // для красивого вывода в консоль
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("output.xml"));
            //записываем данные
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Создание XML файла закончено");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // утилитный метод для создание нового узла XML-файла
    private static Node getLanguageElements(Document doc, Element element, String name, String value) {
        //  System.out.println("СОЗДАЕМ ЖЛЕМЕНТ С ИМЕНЕМ:" + name);
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    private static Node getNote_poison(Document doc, String num, String average_age) {

        Element poisonous = doc.createElement("Poisonous");
        poisonous.appendChild(getLanguageElements(doc, poisonous, "number", num));
        poisonous.appendChild(getLanguageElements(doc, poisonous, "average_age", average_age));
        return poisonous;
    }

    private static Node getNote_no_poison(Document doc, String num, String average_age) {

        Element poisonous = doc.createElement("Nonpoisonous");
        poisonous.appendChild(getLanguageElements(doc, poisonous, "number", num));
        poisonous.appendChild(getLanguageElements(doc, poisonous, "average_age", average_age));
        return poisonous;
    }


    private static Node getpoisonElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
