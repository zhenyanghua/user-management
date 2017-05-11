package io.hua.um.persistence.model;

import io.hua.common.interfaces.INameableDto;
import io.hua.common.persistence.model.INameableEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role implements INameableEntity, INameableDto{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = {
            @JoinColumn(
                name = "ROLE_ID",
                referencedColumnName = "ROLE_ID"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "PRIV_ID",
                referencedColumnName = "PRIV_ID"
            )
        }
    )
    private Set<Privilege> privileges;

    public Role() {
        super();
    }

    public Role(final String name) {
        this.name = name;
    }

    public Role(final String name, final Set<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(final Long id) {

    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(final Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Role other = (Role) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("name", name)
            .toString();
    }
}
