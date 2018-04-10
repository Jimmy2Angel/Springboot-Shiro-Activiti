package indi.baojie.supervision.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * @author lollipop
 */
public class Role implements Serializable{

    private static final long serialVersionUID = 3000436449954215387L;

    private Integer id;

    private String name;

    private Set<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
