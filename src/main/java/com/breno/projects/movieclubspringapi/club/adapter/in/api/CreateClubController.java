package com.breno.projects.movieclubspringapi.club.adapter.in.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.breno.projects.movieclubspringapi.club.adapter.in.api.request.CreateClubRequest;
import com.breno.projects.movieclubspringapi.club.adapter.in.api.response.CreateClubResponse;
import com.breno.projects.movieclubspringapi.club.application.domain.Club;
import com.breno.projects.movieclubspringapi.club.application.port.in.CreateClubUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class CreateClubController {

	private final CreateClubUseCase createClubUseCase;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CreateClubResponse create(@Valid @RequestBody CreateClubRequest requestBody) {
		UUID currentUserId = UUID.randomUUID();
		Club club = createClubUseCase.createClub(currentUserId, requestBody.getName());
		
		return new CreateClubResponse(club.getId(), club.getOwnerId(), club.getName());
	}
}
