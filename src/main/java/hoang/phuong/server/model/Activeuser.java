package hoang.phuong.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "activeuser")
public class Activeuser implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String EMAIL_REGEX =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final java.util.regex.Pattern EMAIL_PATTERN =
            java.util.regex.Pattern.compile(EMAIL_REGEX);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_active")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id_active;
    @NotNull
    @Pattern(regexp = EMAIL_REGEX)
    @SafeHtml
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "username", nullable = true, length = 50)
    private String username;
    @Basic
    @Column(name = "userLastName", nullable = true, length = 50)
    private String userLastName;
    @Basic
    @Column(name = "KeyCode", nullable = true, length = 100)
    private String keyCode;
    private String id;
    private int idActive;

    public Integer getId_active() {
        return id_active;
    }

    public void setId_active(Integer id_active) {
        this.id_active = id_active;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userLastName", nullable = true, length = 50)
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Basic
    @Column(name = "KeyCode", nullable = true, length = 100)
    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activeuser that = (Activeuser) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (userLastName != null ? !userLastName.equals(that.userLastName) : that.userLastName != null) return false;
        if (keyCode != null ? !keyCode.equals(that.keyCode) : that.keyCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (keyCode != null ? keyCode.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "id_active", nullable = false)
    public int getIdActive() {
        return idActive;
    }

    public void setIdActive(int idActive) {
        this.idActive = idActive;
    }
}
