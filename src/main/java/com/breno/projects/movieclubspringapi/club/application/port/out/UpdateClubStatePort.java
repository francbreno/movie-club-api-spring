package com.breno.projects.movieclubspringapi.club.application.port.out;

import com.breno.projects.movieclubspringapi.club.domain.Club;

public interface UpdateClubStatePort {

	void save(Club club);
}
