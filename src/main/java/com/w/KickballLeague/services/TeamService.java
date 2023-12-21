package com.w.KickballLeague.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w.KickballLeague.models.Team;
import com.w.KickballLeague.repositories.TeamRepository;


@Service
public class TeamService {
	@Autowired
	TeamRepository teamRepository;
   
	// READ ALL
		public List<Team>allTeams(){
			return teamRepository.findAll();
		}
		
		// create a new team
		public Team createTeam(Team t) {
			return teamRepository.save(t);
		}
		
		// READ ONE
		public Team findTeam(Long id) {
			Optional<Team> team =teamRepository.findById(id);
			if(team.isPresent()) {
				return team.get();
			}else {
				return null;
			}
		}
		 
		  //edit a team
		 public Team updateTeam(Team t) {
			 return  teamRepository.save(t);
		    }
		
		//delete a team
		public void deleteTeam(Long id) {
			teamRepository.deleteById(id);
		}
		  
	}


