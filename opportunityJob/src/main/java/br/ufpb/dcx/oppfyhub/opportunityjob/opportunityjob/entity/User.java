package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.entity;

import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.enums.RoleUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long authID;

    private String name;

    private String email;

    private RoleUser roleUser;

    @JsonIgnore
    @ManyToMany(mappedBy = "interestedUsers")
    private List<Job> interestedJobs;

    public User(String email, String name, RoleUser roleUser, long authID) {
        this.email = email;
        this.name = name;
        this.authID = authID;
        this.roleUser = roleUser;
    }
}
