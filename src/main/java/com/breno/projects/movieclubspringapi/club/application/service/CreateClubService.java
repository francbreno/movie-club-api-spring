package com.breno.projects.movieclubspringapi.club.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.breno.projects.movieclubspringapi.club.application.domain.Club;
import com.breno.projects.movieclubspringapi.club.application.port.in.CreateClubUseCase;
import com.breno.projects.movieclubspringapi.club.application.port.out.UpdateClubStatePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateClubService implements CreateClubUseCase {
	
	private final UpdateClubStatePort updateClubStatePort;

	@Override
	public Club createClub(UUID userId, String name) {
		Club club = new Club(UUID.randomUUID(), userId, name);
		updateClubStatePort.save(club);
		return club;
	}
}
