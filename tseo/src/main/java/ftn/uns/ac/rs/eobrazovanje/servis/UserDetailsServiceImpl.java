package ftn.uns.ac.rs.eobrazovanje.servis;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.eobrazovanje.model.Korisnik;
import ftn.uns.ac.rs.eobrazovanje.repository.KorisnikRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private KorisnikRepository userRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik user = userRepo.findByKorisnickoIme(username);

		if (user == null) {
			return null;
		} else {

			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//			grantedAuthorities.add(new SimpleGrantedAuthority(user.getAuthority().toString()));
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getAuthorities().toString()));

			return new org.springframework.security.core.userdetails.User(user.getKorisnickoIme(), user.getLozinka(),
					grantedAuthorities);
		}

	}

}