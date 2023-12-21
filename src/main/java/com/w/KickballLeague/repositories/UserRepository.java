package com.w.KickballLeague.repositories;

import java.util.List;
import java.util.Optional;

import com.w.KickballLeague.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	 Optional<User>findByEmail(String email);
	   List<User>findAll();

}
