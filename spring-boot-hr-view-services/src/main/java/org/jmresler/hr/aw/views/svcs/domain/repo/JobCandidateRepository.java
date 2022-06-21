package org.jmresler.hr.aw.views.svcs.domain.repo;

import org.jmresler.hr.aw.views.svcs.domain.VJobCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobCandidateRepository extends JpaRepository<VJobCandidate, Integer> {

}
