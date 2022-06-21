package org.jmresler.hr.aw.views.svcs.services;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.hr.aw.views.svcs.domain.VJobCandidate;
import org.jmresler.hr.aw.views.svcs.domain.repo.JobCandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class JobCandidateService {

    @Autowired
    protected JobCandidateRepository repository;

    public VJobCandidate findJobCandidateById(final Integer id) {
        var candidate = repository.findById(id).orElseThrow(NoJobCandidateViewException::new);
        return cleanupNulls(candidate);
    }


    private VJobCandidate cleanupNulls(final VJobCandidate jobCandidate) {
        if (jobCandidate.getCity() == null)
            jobCandidate.setCity("");
        if (jobCandidate.getCountryRegion() == null)
            jobCandidate.setCountryRegion("USA");
        if (jobCandidate.getEMail() == null)
            jobCandidate.setEMail("");
        if (jobCandidate.getFirst() == null)
            jobCandidate.setFirst("");
        if (jobCandidate.getMiddle() == null)
            jobCandidate.setMiddle("");
        if (jobCandidate.getLast() == null)
            jobCandidate.setLast("");
        if (jobCandidate.getModifiedDate() == null)
            jobCandidate.setModifiedDate(new Date(System.currentTimeMillis()));
        if (jobCandidate.getPostalCode() == null)
            jobCandidate.setPostalCode("");
        if (jobCandidate.getPrefix() == null)
            jobCandidate.setPrefix("");
        if (jobCandidate.getSuffix() == null)
            jobCandidate.setSuffix("");
        if (jobCandidate.getSkills() == null)
            jobCandidate.setSkills("none listed");
        if (jobCandidate.getState() == null)
            jobCandidate.setState("");
        if (jobCandidate.getType() == null)
            jobCandidate.setType("");
        if (jobCandidate.getWebSite() == null)
            jobCandidate.setWebSite("");

        return jobCandidate;
    }

}
