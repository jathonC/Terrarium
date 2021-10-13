package com.company;
import com.company.model.Build_xml;
import com.company.model.Terrarium;
import com.company.model.SaxMyParser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        SaxMyParser saxParser = new SaxMyParser();
        Terrarium terrarium = SaxMyParser.parse();
        Build_xml.build(terrarium);
    }
}

