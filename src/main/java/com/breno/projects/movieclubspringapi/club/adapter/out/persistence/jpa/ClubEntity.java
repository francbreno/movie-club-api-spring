package com.breno.projects.movieclubspringapi.club.adapter.out.persistence.jpa;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClubEntity {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	
	private UUID clubId;
	private UUID userId;
	private String name;
}
