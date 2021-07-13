package ftn.uns.ac.rs.eobrazovanje.servis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.eobrazovanje.dto.LoginDTO;
import ftn.uns.ac.rs.eobrazovanje.model.Korisnik;
import ftn.uns.ac.rs.eobrazovanje.repository.KorisnikRepository;
import ftn.uns.ac.rs.eobrazovanje.security.TokenUtils;

@Service
public class KorisnikService extends CrudService<Korisnik, KorisnikRepository, Long> {

	@Autowired
	KorisnikRepository korisnikRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	TokenUtils tokenUtils;
	
	public Map<String, Object> login(LoginDTO loginDTO) {
		Map<String, Object> cookie = new HashMap<>();

		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
					loginDTO.getPassword());

			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());

			cookie.put("jwt", tokenUtils.generateToken(details));

			return cookie;
		} catch (NullPointerException nullException) {
			System.out.println("User doesn't exist.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public Korisnik findByUsername(String username) {
		return korisnikRepository.findByKorisnickoIme(username);
	}

//	public List<Korisnik> getAll(){
//		return korisnikRepository.findAll();
//	}
//	
//	public Korisnik getOne(Long id) {
//		return korisnikRepository.findById(id).orElse(null);
//	}
//	
//	public Korisnik save(Korisnik k) {
//		return korisnikRepository.save(k);
//	}

}
