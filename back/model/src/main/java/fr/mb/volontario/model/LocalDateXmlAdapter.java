package fr.mb.volontario.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {
	
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v,formatter);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        if (v != null) {
            return v.format(formatter);
        } else {
            return null;
        }
    }
}

