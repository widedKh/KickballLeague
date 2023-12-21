package com.w.KickballLeague.repositories;

import java.util.List;

import com.w.KickballLeague.models.Team;


import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
	List<Team>findAll();

}
