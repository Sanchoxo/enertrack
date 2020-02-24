package de.changeperspective.enertrack.persistence.dto;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotNull
    @Column(unique = true)
    private String nickName;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<EnergyMeter> energyMeters = new ArrayList<>();

    /**
     * only for JPA.
     */
    protected User() {
    }

    public User(@NotNull String nickName, @Email @NotNull String email, String password) {
        this.nickName = nickName;
        this.email = email;
        setPassword(password);
    }

    public String getNickName() {
        return nickName;
    }

    public void changeNickName(String nickName, String password) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void changeEmail(String email, String password) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("PASSWORT: " + this.password);
    }

    public List<EnergyMeter> getEnergyMeters() {
        return Collections.unmodifiableList(energyMeters);
    }

    public void addEnergyMeters(List<EnergyMeter> energyMeters) {
        this.energyMeters.addAll(energyMeters);
    }

    public void addEnergyMeter(EnergyMeter energyMeter) {
        this.energyMeters.add(energyMeter);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", energyMeters=" + energyMeters +
                '}';
    }
}
