package org.anderes.edu.employee.domain;

import static java.lang.Boolean.TRUE;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Diese Klasse repräsentiert ein Projekt in dem eine Gruppe von Mitarbeitern tätig ist.
 * <p>
 * Beispiel für JOINED inheritance.
 * </p>
 * Die Klasse demonstriert die Möglichkeit eines Konverterts (JPA 2.1)
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PROJ_TYPE")
public abstract class Project implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PROJ_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Basic
    @Column(name = "PROJ_NAME")
    private String name;
    @Basic
    @Column(name = "DESCRIP")
    private String description;
    @Version
    private long version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEADER_ID")
    private Employee teamLeader;
    // JPA 2.1 Converter
    @Convert(converter = BooleanActiveConverter.class)
    @Column(name = "STATUS")
    private Boolean isActive = TRUE;

    public Project() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String descrip) {
        this.description = descrip;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String projName) {
        this.name = projName;
    }

    public long getVersion() {
        return version;
    }

    public Optional<Employee> getTeamLeader() {
        return Optional.ofNullable(teamLeader);
    }

    public void setTeamLeader(Employee employee) {
        this.teamLeader = employee;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setIsActive(final Boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(description).append(name)
                        .append(teamLeader).append(isActive).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
          return false;
        }
        final Project rhs = (Project) obj;
        return new EqualsBuilder().append(description, rhs.description).append(name, rhs.name)
                        .append(teamLeader, rhs.teamLeader).append(isActive, rhs.isActive).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("description", description)
                        .append("teamLeader", teamLeader).append("isActive", isActive).toString();
    }
}
