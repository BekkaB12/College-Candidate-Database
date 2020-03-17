package net.codejava;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CandidateService {

	@Autowired
	private CandidateRepository repo;
	
	public List <Candidate> listAll() {
        return repo.findAll();
    }
	
	public void save(Candidate candidate) {
        repo.save(candidate);
    }
	
	public Candidate get(Long primaryKey) {
        return repo.findById(primaryKey).get();
    }
	
	public void delete(Long primaryKey) {
        repo.deleteById(primaryKey);
    }

}
