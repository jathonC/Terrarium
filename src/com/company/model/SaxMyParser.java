package com.company.model;

import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxMyParser  {
    public static Terrarium parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Eror sax parser + " + e.toString());
            return null;
        }
        File file = new File("test.xml");
        try {
            parser.parse(file,handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error + " + e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error+ "  + e.toString());
            return null;
        }

        return handler.getTerrarium();

    }
}
