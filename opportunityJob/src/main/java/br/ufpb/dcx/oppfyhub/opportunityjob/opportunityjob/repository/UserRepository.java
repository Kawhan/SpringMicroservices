package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.repository;



import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    Optional<User> findByEmail(String email);

}
