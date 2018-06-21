package Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name = "users", schema = "userlist")
public class UsersEntity {
    private int id;
    private String email;
    private String password;
    private Calendar timeregistration;

    public UsersEntity() {
    }

    public UsersEntity(int sId, String sEmail, String sPassword) throws ParseException {
        this.id = sId;
        this.email = sEmail;
        this.password = sPassword;
        Calendar c = new GregorianCalendar();
        this.timeregistration = c;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "timeregistration", nullable = true)
    public Calendar getTimeregistration() {
        return timeregistration;
    }

    public void setTimeregistration(Calendar createDate) {
        this.timeregistration = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

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
