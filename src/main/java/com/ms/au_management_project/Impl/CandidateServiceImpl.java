package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.repository.CandidateRepository;
import com.ms.au_management_project.response.CandidateResponse;
import com.ms.au_management_project.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public CandidateResponse addCandidate(Candidate candidate) {
        try {
            candidate.setJoinDate(new Date());
            Candidate candidate1 = candidateRepository.save(candidate);
            return new CandidateResponse(true, "candidate added", candidate1.getCandidateId(), candidate1.getCandidateName(), candidate1.getJoinDate(), candidate1.getEmailId(), candidate1.getLocation(), candidate1.getPassword());
        }catch (Exception e) {
            CandidateResponse candidateResponse = new CandidateResponse();
            candidateResponse.setCandidateId(0);
            candidateResponse.setValid(false);
            candidateResponse.setMessage("candidate not added");
         return candidateResponse;
        }
    }

    @Override
    public CandidateResponse getCandidateByEmailId(String emailId) {
        Optional<Candidate> optionalCandidate = candidateRepository.findCandidateByEmailId(emailId);
        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();
            return new CandidateResponse(true, "authorized user", candidate.getCandidateId(), candidate.getCandidateName(), candidate.getJoinDate(), candidate.getEmailId(), candidate.getLocation(), candidate.getPassword());
        }

        CandidateResponse candidateResponse = new CandidateResponse();
        candidateResponse.setValid(false);
        candidateResponse.setMessage("unauthorized user");
        return candidateResponse;
    }
}
