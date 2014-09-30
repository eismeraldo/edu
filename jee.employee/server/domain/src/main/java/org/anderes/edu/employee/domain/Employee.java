package org.anderes.edu.employee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Ein Mitarbeiter
 * </p>
 * Demonstriert unterschiedliche JPA Techniken:
 * <ul>
 * <li>Generated Id
 * <li>Version locking
 * <li>OneToOne relationships (dependent, and independent)
 * <li>OneToOne relationship using JoinTable
 * <li>ManyToMany relationship
 * <li>OneToMany relationship (dependent, and independent)
 * <li>Embedded relationship
 * <li>ElementCollection relationships (Basic, and Embeddable)
 * <li>enums
 * <li>OrderColumn
 * <li>MapKeyColumn
 * <li>orphanRemoval
 * <li>@Index (Index für die Datenbank)
 * <li>Named Queries
 * </ul>
 */
@Entity
@Table(indexes = { 
        @Index(columnList = "F_NAME"), 
        @Index(columnList = "L_NAME") 
    })
@SecondaryTable(name = "SALARY")
@NamedQueries({
    @NamedQuery(
        name="findAllEmployeeBySalary", 
        query="Select e from Employee e where e.salary > :salary"),
    @NamedQuery(
        name="findEmployeeInLargeProject", 
        query="Select e from Employee e where exists (Select p from LargeProject p where p member of e.projects and p.budget >= :budget)")
	})
public class Employee implements Serializable {
    
    public final static String FINDALLEMPLOYEE_BY_SALARY = "findAllEmployeeBySalary";
    public final static String FINDEMPLOYEE_IN_LARGEPROJECT = "findEmployeeInLargeProject";
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Version
    private long version;

    @Column(name = "F_NAME")
    private String firstName;

    @Column(name = "L_NAME")
    private String lastName;

    @Basic
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.Male;

    @Column(table = "SALARY")
    private Double salary;

    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name = "startDate", column = @Column(name = "START_DATE")),
        @AttributeOverride(name = "endDate", column = @Column(name = "END_DATE")) })
    private EmploymentPeriod period = new EmploymentPeriod();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDR_ID")
    private Address address;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "EMP_JOB", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "TITLE_ID"))
    private JobTitle jobTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> managedEmployees = new ArrayList<Employee>();

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="EMP_ID")
    private List<Degree> degrees = new ArrayList<Degree>();

    @ManyToMany
    @JoinTable(name = "PROJ_EMP", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PROJ_ID"))
    private List<Project> projects = new ArrayList<Project>();

    @ElementCollection
    @CollectionTable(name = "RESPONSE", joinColumns = @JoinColumn(name = "EMP_ID"))
    @Column(name = "RESPONSIBILITY")
    @OrderColumn(name = "PRIORITY")
    private List<String> responsibilities = new ArrayList<String>();

    @OneToMany
    @JoinColumn(name="EMP_ID")
    @MapKeyColumn(name = "EMAIL_TYPE")
    private Map<String, EmailAddress> emailAddresses = new HashMap<String, EmailAddress>();
    
    @OneToOne
    @JoinColumn(name = "PARKINGSPACE_ID")
    private ParkingSpace parkingSpace;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String fName) {
        this.firstName = fName;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lName) {
        this.lastName = lName;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(final long version) {
        this.version = version;
    }
    
    public List<Degree> getDegrees() {
        return Collections.unmodifiableList(degrees);
    }

    public Degree addDegree(final String degree) {
        return addDegree(new Degree(degree));
    }

    public Degree addDegree(final Degree degree) {
        degrees.add(degree);
        return degree;
    }

    public void removeDegree(final Degree degree) {
        degrees.remove(degree);
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public Project addProject(final Project project) {
        getProjects().add(project);
        return project;
    }

    public Project removeProject(final Project project) {
        getProjects().remove(project);
        return project;
    }

    public Optional<Employee> getManager() {
        return Optional.ofNullable(manager);
    }

    public void setManager(final Employee employee) {
        this.manager = employee;
    }

    public List<Employee> getManagedEmployees() {
        return managedEmployees;
//        return Collections.unmodifiableList(managedEmployees);
    }

    public Employee addManagedEmployee(final Employee employee) {
        getManagedEmployees().add(employee);
        employee.setManager(this);
        return employee;
    }

    public Employee removeManagedEmployee(final Employee employee) {
        getManagedEmployees().remove(employee);
        employee.setManager(null);
        return employee;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return Collections.unmodifiableList(phoneNumbers);
    }

    public PhoneNumber addPhoneNumber(final PhoneNumber phoneNumber) {
        getPhoneNumbers().add(phoneNumber);
        phoneNumber.setOwner(this);
        return phoneNumber;
    }

    public PhoneNumber addPhoneNumber(final String type, final String areaCode, final String number) {
        PhoneNumber phoneNumber = new PhoneNumber(type, areaCode, number);
        return addPhoneNumber(phoneNumber);
    }

    public void removePhoneNumber(final PhoneNumber phoneNumber) {
        getPhoneNumbers().remove(phoneNumber);
        phoneNumber.setOwner(null);
    }

    public Optional<ParkingSpace> getParkingSpace() {
        return Optional.ofNullable(this.parkingSpace);
    }
    
    public void setParkingSpace(final ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
        this.parkingSpace.setOwner(this);
    }
    
    public void removeParkingSpace(final ParkingSpace parkingSpace) {
        this.parkingSpace = null;
        parkingSpace.setOwner(null);
    }
    
    public void setAddress(final Address address) {
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public void setPeriod(final EmploymentPeriod period) {
        this.period = period;
    }

    public EmploymentPeriod getPeriod() {
        return period;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(final Double salary) {
        this.salary = salary;
    }

    public List<String> getResponsibilities() {
        return Collections.unmodifiableList(responsibilities);
    }

    public void addResponsibility(final String responsibility) {
        responsibilities.add(responsibility);
    }

    public void removeResponsibility(final String responsibility) {
        responsibilities.remove(responsibility);
    }
    
    public Map<String, EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public EmailAddress addEmailAddress(final String type, final String newAddress) {
        return addEmailAddress(type, new EmailAddress(newAddress));
    }

    public EmailAddress addEmailAddress(final String type, final EmailAddress newAddress) {
        return emailAddresses.put(type, newAddress);
    }

    public EmailAddress removeEmailAddress(final String type) {
        return emailAddresses.remove(type);
    }

    public EmailAddress getEmailAddress(final String type) {
        return emailAddresses.get(type);
    }
    
    public Optional<JobTitle> getJobTitle() {
        return Optional.ofNullable(jobTitle);
    }

    public void setJobTitle(final JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    private Optional<Long> getIdFromManagerIfPresent() {
        Long managerId = null;
        if (getManager().isPresent()) {
            managerId = getManager().get().getId();
        }
        return Optional.ofNullable(managerId);
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(firstName).append(lastName)
                        .append(gender).append(salary).append(period)
                        .append(address).append(jobTitle).append(getIdFromManagerIfPresent())
                        .append(managedEmployees).append(phoneNumbers).append(degrees)
                        .append(projects).append(responsibilities).append(emailAddresses)
                        .append(parkingSpace)
                        .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
          return false;
        }
        final Employee rhs = (Employee) obj;
        return new EqualsBuilder().append(firstName, rhs.firstName).append(lastName, rhs.lastName)
                        .append(gender, rhs.gender).append(salary, rhs.salary).append(period, rhs.period)
                        .append(address, rhs.address).append(jobTitle, rhs.jobTitle)
                        .append(getIdFromManagerIfPresent(), rhs.getIdFromManagerIfPresent())
                        .append(managedEmployees, rhs.managedEmployees).append(phoneNumbers, rhs.phoneNumbers)
                        .append(degrees, rhs.degrees).append(projects, rhs.projects)
                        .append(responsibilities, rhs.responsibilities).append(emailAddresses, rhs.emailAddresses)
                        .append(parkingSpace, rhs.parkingSpace)
                        .isEquals();
    }

    @Override
    public String toString() {
        // Mittels ToStringBuilder(this) wird der Hashcode bezogen und dieser löst einen Stackoverflow aus.
        // keine Lösung vorhanden
        return new ToStringBuilder(null).append("id", id).append("firstName", firstName).append("lastName", lastName).toString();
    }
}
