package com.breno.projects.movieclubspringapi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.breno.projects.movieclubspringapi.club.application.port.out.UpdateClubStatePort;
import com.breno.projects.movieclubspringapi.club.application.service.CreateClubService;
import com.breno.projects.movieclubspringapi.club.domain.Club;

class CreateClubUseCaseTests {

	@Mock
	private UpdateClubStatePort updateClubStatePort;
	
	@InjectMocks
	private CreateClubService createClubService;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void test() {
		UUID userId = UUID.randomUUID();
		String clubName = "My Special Club";
		
		Club club = createClubService.createClub(userId, clubName);
		
		assertThat(club.getId()).isNotNull();
		assertThat(club.getOwnerId()).isEqualTo(userId);
		assertThat(club.getName()).isEqualTo(clubName);
	}

}
