package ftn.uns.ac.rs.eobrazovanje.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.eobrazovanje.model.Authority;
import ftn.uns.ac.rs.eobrazovanje.repository.AuthorityRepository;

@Service
public class AuthorityService {
	
	@Autowired
	AuthorityRepository authRepo;
	
	public Authority findByName(String name) {
		return authRepo.findByName(name);
	}

}
