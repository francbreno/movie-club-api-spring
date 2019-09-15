package com.breno.projects.movieclubspringapi.club.adapter.in.api.response;

import java.util.UUID;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CreateClubResponse {
	private final UUID id;
	private final UUID ownerId;
	private final String name;
}
