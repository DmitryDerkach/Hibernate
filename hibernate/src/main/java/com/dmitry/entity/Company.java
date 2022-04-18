package com.dmitry.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users")
@AllArgsConstructor
@Builder
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    @Builder.Default
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    //@JoinColumn(name = "company_id")
    private Set<User> users = new HashSet<>();
    
    public void addUser(User user) {
    	users.add(user);
    	user.setCompany(this);
    }
}