package com.company.model;

import com.company.Reptiles_package.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class SaxParserHandler extends DefaultHandler {

    private static final String TAG_NAME_MAIN = "name";
    private static final String TAG_NAME = "name";
    private static final String TAG_AGE = "age";
    private static final String TAG_POISON = "poison";

    private static final String TAG_REPTILES = "reptiles";
    private static final String TAG_SCALY = "scaly";
    private static final String TAG_CHAMELEONS = "chameleons";
    private static final String TAG_SNAKES = "snakes";
    private static final String TAG_LIZARDS = "lizards";
    private static final String TAG_TURTULES = "turtules";
    private static final String TAG_CROCKODILES = "crockodiles";
    private static final String TAG_REPRESENTATIVE = "representative";


    private Terrarium terrarium = new Terrarium();
    private String currentTagName;
    private String name;
    private int age;
    private boolean poison;

    private boolean isReptiles = false;
    private boolean isScaly = false;
    private boolean isChameleons = false;
    private boolean isSnakes = false;
    private boolean isLizards = false;
    private boolean isTurtles = false;
    private boolean isCrokodiles = false;
    private boolean isRepresentative = false;

    private List<Reptile> reptileslist = new ArrayList<>();

    public Terrarium getTerrarium() {
        return terrarium;
    }

    @Override
    public void startDocument() throws SAXException {
        //     System.out.println("Start doc");
    }

    @Override
    public void endDocument() throws SAXException {
        // System.out.println("End document");
        terrarium.setReptiles(reptileslist);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //  System.out.println("Start element "  + qName);
        currentTagName = qName;
        switch (currentTagName) {
            case TAG_REPTILES:
                isReptiles = true;
                break;
            case TAG_SCALY:
                isScaly = true;
                break;
            case TAG_CHAMELEONS:
                isChameleons = true;
                break;
            case TAG_CROCKODILES:
                isCrokodiles = true;
                break;
            case TAG_LIZARDS:
                isLizards = true;
                break;
            case TAG_TURTULES:
                isTurtles = true;
                break;
            case TAG_REPRESENTATIVE:
                isRepresentative = true;
                break;
            case TAG_SNAKES:
                isSnakes = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        Reptile reptile = new Snake(age, name, poison);
        if (qName.equals(TAG_REPTILES)) {
            isReptiles = false;
        } else if (qName.equals(TAG_REPRESENTATIVE)) {
            isRepresentative = false;
            // System.out.println(qName);
            if (isChameleons) {
                reptile = new Chameleon(age, name, poison);

            } else if (isSnakes) {
                reptile = new Snake(age, name, poison);
                isSnakes = false;
            } else if (isLizards) {
                reptile = new Lizard(age, name, poison);
                isLizards = false;
            } else if (isTurtles) {
                reptile = new Turtule(age, name, poison);
                isTurtles = false;

            } else if (isCrokodiles) {
                reptile = new Crockodile(age, name, poison);
                isCrokodiles = false;
            }
            reptileslist.add(reptile);
        }
        switch (qName) {
            case TAG_CHAMELEONS:
                isChameleons = false;
                break;
            case TAG_SNAKES:
                isSnakes = false;
                break;
            case TAG_LIZARDS:
                isLizards = false;
                break;
            case TAG_CROCKODILES:
                isCrokodiles = false;
                break;
            case TAG_TURTULES:
                isTurtles = false;
                break;
        }
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTagName == null)
            return;
        if (!isRepresentative && currentTagName.equals(TAG_NAME_MAIN)) {
            //System.out.println("Добавляем имя:" + new String(ch, start, length));
            terrarium.setName(new String(ch, start, length));
        }
        if(isReptiles && isRepresentative){
            switch (currentTagName){
                case TAG_NAME:
                    name = new String(ch, start, length);
                    break;
                case TAG_AGE:
                    age = Integer.valueOf(new String(ch, start, length));
                    break;
                case  TAG_POISON:
                    String mbpoison = new String(ch, start, length);
                    if (mbpoison.equals("yes"))
                        poison = true;
                    else if (mbpoison.equals("no"))
                        poison = false;
                    else {
                        System.out.println("Eror:404");
                        System.out.println(mbpoison);
                        return;
                    }
                    break;
            }
        }
    }
}

