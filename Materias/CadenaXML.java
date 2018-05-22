/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materias;

import Modelos.Materias;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class CadenaXML {

    private String cavecera;
    private Materias materias;

    public CadenaXML(Materias materias) {
        /*cavecera = "<?xml version=\"1.0\"?>\n"
                + "<!DOCTYPE MENSAJE SYSTEM \"materias.dtd\">";*/
        this.materias = materias;
    }
    
    public String estructurarXML() throws JAXBException{
        /*String datos = estructurarDatos();
        String XML = cavecera + datos;
        return XML;*/
        StringWriter sw = new StringWriter();
        String XML;
        JAXBContext jaxbContext = JAXBContext.newInstance(Materias.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(materias, sw);
        XML = sw.toString();
        return XML;
    }
}
