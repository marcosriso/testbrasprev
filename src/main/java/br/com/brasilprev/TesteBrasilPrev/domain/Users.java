package br.com.brasilprev.TesteBrasilPrev.domain;

import br.com.brasilprev.TesteBrasilPrev.deserializers.UserDeserializer;
import br.com.brasilprev.TesteBrasilPrev.security.PasswordEncryptor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
@JsonDeserialize(using = UserDeserializer.class)
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "active")
    private Boolean active;

    public Users(String username, String password) {
        this.username = username;
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor(password);
        this.password = passwordEncryptor.getEncryptedPassword();
        this.active = true;
    }
}
