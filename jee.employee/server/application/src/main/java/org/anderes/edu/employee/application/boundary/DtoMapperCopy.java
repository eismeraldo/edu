package org.anderes.edu.employee.application.boundary;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.anderes.edu.employee.application.boundary.dto.AddressDto;
import org.anderes.edu.employee.application.boundary.dto.EmployeeDto;
import org.anderes.edu.employee.application.boundary.dto.ObjectFactory;
import org.anderes.edu.employee.application.boundary.dto.ProjectDto;
import org.anderes.edu.employee.domain.Address;
import org.anderes.edu.employee.domain.Employee;
import org.anderes.edu.employee.domain.Project;
import org.apache.commons.lang3.Validate;

public class DtoMapperCopy implements DtoMapper {

    private ObjectFactory factory = new ObjectFactory();

    @Override
    public EmployeeDto mapToEmployeeDto(final Employee employee) {
        Validate.notNull(employee, "Der Parameter 'employee' darf nicht null sein.'");

        final EmployeeDto dto = factory.createEmployeeDto();
        dto.setFirstname(employee.getFirstName());
        dto.setLastname(employee.getLastName());
        dto.setSalary(new BigDecimal(employee.getSalary()));
        dto.setGender(employee.getGender().name());
        dto.setId(BigInteger.valueOf(employee.getId()));
        if (employee.getJobTitle().isPresent()) {
            dto.setJobtitle(employee.getJobTitle().get().getTitle());
        }
        return dto;
    }

    @Override
    public List<EmployeeDto> mapToEmployeesDto(final List<Employee> employees) {
        Validate.notNull(employees, "Der Parameter 'employees' darf nicht null sein.'");

        final List<EmployeeDto> list = new ArrayList<EmployeeDto>(employees.size());
        for (Employee employee : employees) {
            EmployeeDto e = factory.createEmployeeDto();
            e.setFirstname(employee.getFirstName());
            e.setLastname(employee.getLastName());
            e.setId(BigInteger.valueOf(employee.getId()));
            if (employee.getJobTitle().isPresent()) {
                e.setJobtitle(employee.getJobTitle().get().getTitle());
            }
            list.add(e);
        }
        return list;
    }

    @Override
    public AddressDto mapToAddressDto(final Address address) {
        Validate.notNull(address, "Der Parameter 'address' darf nicht null sein.'");

        final AddressDto addressDto = factory.createAddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setProvince(address.getProvince());
        addressDto.setStreet(address.getStreet());
        return addressDto;
    }

    @Override
    public List<ProjectDto> mapToProjectsDto(final List<Project> projects) {
        Validate.notNull(projects, "Der Parameter 'projects' darf nicht null sein.'");

        final List<ProjectDto> projectsDto = new ArrayList<ProjectDto>(projects.size());
        for (Project project : projects) {
            projectsDto.add(mapToProject(project));
        }
        return projectsDto;
    }

    private ProjectDto mapToProject(final Project project) {
        Validate.notNull(project, "Der Parameter 'project' darf nicht null sein.'");
        
        final ProjectDto dto = factory.createProjectDto();
        dto.setDescription(project.getDescription());
        dto.setName(project.getName());
        dto.setId(BigInteger.valueOf(project.getId()));
        return dto;
    }
}
