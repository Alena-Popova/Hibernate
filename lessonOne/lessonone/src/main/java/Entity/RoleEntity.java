package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role", schema = "userlist")
public class RoleEntity {
    private int id;
    private String title;
    /*@OneToMany(mappedBy = "role")
    private Set<UsersEntity> userSet = new HashSet<UsersEntity>();*/

    public RoleEntity () {

    }

    public RoleEntity (int sId, String sTitle) {
        this.id  = sId;
        this.title = sTitle;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   /* @Basic
    @Column(name = "users", nullable = true)
    public Set<UsersEntity> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<UsersEntity> userSet) {
        this.userSet = userSet;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
