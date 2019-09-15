package com.breno.projects.movieclubspringapi.club.application.port.in;

import java.util.UUID;

import com.breno.projects.movieclubspringapi.club.application.domain.Club;

public interface CreateClubUseCase {

	Club createClub(UUID userId, String name);

}
