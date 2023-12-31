package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.repository;


import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.entity.Job;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.enums.TypeJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByTitleJobStartingWith(String titleJob);

    List<Job> findByTypeJob(TypeJob typeJob);

    @Query("SELECT j FROM Job j JOIN j.interestedUsers u WHERE u.id = :userId")
    List<Job> findJobsByUserIdInterested(Long userId);

}
