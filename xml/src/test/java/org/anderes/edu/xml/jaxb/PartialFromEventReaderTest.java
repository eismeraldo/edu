package org.anderes.edu.xml.jaxb;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import org.anderes.edu.xml.jaxb.generated.Contact;
import org.anderes.edu.xml.jaxb.generated.ObjectFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * In diesem Beispiel wird jeder Kontakt einzeln ausgelesen
 * und deserialiesiert. Dadurch ist es möglich, auch grosse
 * XML-Files einzulsesen ohne Speicherprobleme, da immer nur ein
 * Kontakt im Speicher liegt.
 * 
 * @author René Anderes
 *
 */
public class PartialFromEventReaderTest {

    private InputStream inputStream;
    private Unmarshaller jaxbUnmarshaller;

    @Before
    public void setup() throws Exception {
        inputStream = getClass().getResourceAsStream("/org/anderes/edu/xml/introduction/contactlist.xml");
        assertThat(inputStream, is(notNullValue()));
        jaxbUnmarshaller = JAXBContext.newInstance(ObjectFactory.class).createUnmarshaller();
    }
    
    @After
    public void shutdown() throws IOException {
        inputStream.close();
    }
    
    @Test
    public void shouldBeReadPartialFromFile() throws Exception {
       
        final QName searchElement = new QName("contact");
        final XMLEventReader eventReader = XMLInputFactory.newInstance().createXMLEventReader(inputStream, "UTF-8");
        
        XMLEvent xmlEvent;
        while ((xmlEvent = eventReader.peek()) != null) {
            if (xmlEvent.isStartElement()) {
                if (xmlEvent.asStartElement().getName().equals(searchElement)) {
                    final Contact contact = jaxbUnmarshaller.unmarshal(eventReader, Contact.class).getValue();
                    assertThat(contact, is(notNullValue()));
                    assertThat(contact.getName(), is(notNullValue()));
                } 
            } 
            xmlEvent = eventReader.nextEvent();
        }
    }
}
