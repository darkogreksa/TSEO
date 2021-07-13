package ftn.uns.ac.rs.eobrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.uns.ac.rs.eobrazovanje.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findByName(String name);
}
