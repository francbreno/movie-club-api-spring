package com.breno.projects.movieclubspringapi.club.domain;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Club {
	@EqualsAndHashCode.Include
	private final UUID id;
	private final UUID ownerId;
	private final String name;
}
