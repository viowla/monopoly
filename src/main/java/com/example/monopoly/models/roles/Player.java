package com.example.monopoly.models.roles;

import com.example.monopoly.models.Bank;
import com.example.monopoly.models.Dice;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class Player implements UserDetails {
    int totalWalk = 0;
    int position = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    boolean brokeout = false;

    @Column(unique = true)
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Roles> roles;

    @OneToOne
    Bank money = new Bank(5000);

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public int tossDie(Dice die) {
        int face = die.getFace();

        // getName() lombok
        Observer.print(this, getName() + " toss a die... Face is " + face);
        return face;
    }


    public void nextTurn() {
        totalWalk++;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    /*-----------Getter/Setter---------------*/
    /*public int getCurrentPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Bank getMoney() {
        return money;
    }

    public Long getID() {
        return id;
    }
*/
    public void setBrokeOut(boolean brokeout) {
        this.brokeout = brokeout;
    }

    public boolean isBrokeOut() {
        return brokeout;
    }
/*
    public int getTotalWalk() {
        return totalWalk;
    }*/

    /*------------Setter username/password---------------*/

    /*public void setPassword(String password) {
        this.password = password;
}

    public void setUsername(String username) {
        this.username = username;
    }*/
}
