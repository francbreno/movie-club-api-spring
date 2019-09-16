package com.breno.projects.movieclubspringapi.club.adapter.out.persistence.jpa;

import org.springframework.stereotype.Component;

import com.breno.projects.movieclubspringapi.club.application.port.out.UpdateClubStatePort;
import com.breno.projects.movieclubspringapi.club.domain.Club;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClubPersistenceAdapter implements UpdateClubStatePort {

	private final ClubRepository clubRepository;
	
	@Override
	public void save(Club club) {
		ClubEntity clubEntity = new ClubEntity(
				null,
				club.getId(),
				club.getOwnerId(),
				club.getName());
		
		clubRepository.save(clubEntity);
	}
	
}
