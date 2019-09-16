package com.breno.projects.movieclubspringapi.club.adapter.out.persistence.jpa;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clubs")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClubEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private UUID clubId;
	private UUID userId;
	private String name;
}
