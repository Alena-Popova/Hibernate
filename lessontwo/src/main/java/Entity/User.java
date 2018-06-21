package Entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name = "users")
public class User {
    private int id;
    private String email;
    private String password;
    private Calendar timeregistration;
    private Role role;

    public User() {
    }

    public User(int sId, String sEmail, String sPassword,Role sRole) throws ParseException {
        this.id = sId;
        this.email = sEmail;
        this.password = sPassword;
        Calendar c = new GregorianCalendar();
        this.timeregistration = c;
        this.role = sRole;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "timeregistration", nullable = true)
    public Calendar getTimeregistration() {
        return timeregistration;
    }

    public void setTimeregistration(Calendar createDate) {
        this.timeregistration = createDate;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    @Basic
    @Column(name = "role", nullable = true)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (timeregistration != null ? !timeregistration.equals(that.timeregistration) : that.timeregistration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (timeregistration != null ? timeregistration.hashCode() : 0);
        return result;
    }
}
