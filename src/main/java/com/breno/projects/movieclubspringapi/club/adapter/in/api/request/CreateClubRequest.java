package com.breno.projects.movieclubspringapi.club.adapter.in.api.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CreateClubRequest {
	@NotNull
	@Size(max=255)
	private final String name;
}
