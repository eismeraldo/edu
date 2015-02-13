package ch.vrsg.edu.webservice.application;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@XmlRootElement(name="Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlElement
    private final String firstname;
    @XmlElement
    private final String lastname;
    
    Employee() {
        super();
        this.firstname = "";
        this.lastname = "";
    }
    
    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public static Employee build(String firstname, String lastname) {
        return new Employee(firstname, lastname);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(firstname).append(lastname).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
          return false;
        }
        Employee rhs = (Employee) obj;
        return new EqualsBuilder()
                      .appendSuper(super.equals(obj))
                      .append(firstname, rhs.firstname)
                      .append(lastname, rhs.lastname)
                      .isEquals();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
