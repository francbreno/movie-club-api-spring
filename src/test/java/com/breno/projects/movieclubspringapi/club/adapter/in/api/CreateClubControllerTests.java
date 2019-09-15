package com.breno.projects.movieclubspringapi.club.adapter.in.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.breno.projects.movieclubspringapi.club.adapter.in.api.request.CreateClubRequest;
import com.breno.projects.movieclubspringapi.club.adapter.in.api.response.CreateClubResponse;
import com.breno.projects.movieclubspringapi.club.application.domain.Club;
import com.breno.projects.movieclubspringapi.club.application.port.in.CreateClubUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CreateClubController.class)
class CreateClubControllerTests {

	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private CreateClubUseCase createClubUseCase;
	
	@Test
	void shouldCreateNewClubAndReturnStatusCreated() throws Exception {
		String clubName = "My New Club";
		CreateClubRequest requestBody = new CreateClubRequest(clubName);
		
		when(createClubUseCase.createClub(
				Mockito.any(UUID.class),
				Mockito.anyString())).thenReturn(new Club(UUID.randomUUID(), UUID.randomUUID(), clubName));
		
		MvcResult result = mockMvc
			.perform(post("/clubs")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(mapper.writeValueAsString(requestBody))
					.characterEncoding("UTF-8"))
			.andExpect(status().isCreated())
			.andDo(print())
			.andReturn();
		
		CreateClubResponse responseBody = mapper.readValue(
				result.getResponse().getContentAsString(),
				CreateClubResponse.class);
		
		assertThat(responseBody.getId()).isNotNull();
		assertThat(responseBody.getOwnerId()).isNotNull();
		assertThat(responseBody.getName()).isEqualTo(requestBody.getName());
	}
	
	@Test
	void shouldNotCreateNewClubAndReturnBadRequestIfRequestDataIsInvalid() throws Exception {
		CreateClubRequest requestBody = new CreateClubRequest(null);
		
		MvcResult result = mockMvc
				.perform(post("/clubs")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(mapper.writeValueAsString(requestBody))
						.characterEncoding("UTF-8"))
				.andExpect(status().isBadRequest())
				.andDo(print())
				.andReturn();
	}
}
