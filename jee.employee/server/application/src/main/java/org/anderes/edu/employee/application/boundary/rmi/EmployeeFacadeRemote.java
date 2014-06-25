package org.anderes.edu.employee.application.boundary.rmi;

import java.util.List;

import javax.ejb.Remote;

import org.anderes.edu.employee.application.boundary.dto.EmployeeDto;

/**
 * Remote-Interface für den JNDI-Lookup
 * Via RMI kann der Client diese Schnittstelle benutzen.
 */
@Remote
public interface EmployeeFacadeRemote {

    /**
     * Liefert eine Liste mit allen Mitarebitern, deren Jahresgehalt
     * grösser dem übergebenen Wert ist.
     * 
     * @param salary
     *            Jahreslohn
     * @return Mitarbeiterliste mit Jahreslohn
     */
    public List<EmployeeDto> getSalaryList(final Double salary);
}
