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
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s']{3,250}$")
    @SafeHtml
    @Column(name = "username", nullable = true, length = 50)
    private String username;
    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s']{3,250}$")
    @SafeHtml
    @Column(name = "userLastName", nullable = true, length = 50)
    private String userLastName;
    @Basic
    @Column(name = "KeyCode", nullable = true, length = 100)
    private String keyCode;

    public Integer getId_active() {
        return id_active;
    }

    public void setId_active(Integer id_active) {
        this.id_active = id_active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

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

        if (getId_active() != null ? !getId_active().equals(that.getId_active()) : that.getId_active() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null)
            return false;
        if (getUserLastName() != null ? !getUserLastName().equals(that.getUserLastName()) : that.getUserLastName() != null)
            return false;
        return getKeyCode() != null ? getKeyCode().equals(that.getKeyCode()) : that.getKeyCode() == null;
    }

    @Override
    public int hashCode() {
        int result = getId_active() != null ? getId_active().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getUserLastName() != null ? getUserLastName().hashCode() : 0);
        result = 31 * result + (getKeyCode() != null ? getKeyCode().hashCode() : 0);
        return result;
    }
}
