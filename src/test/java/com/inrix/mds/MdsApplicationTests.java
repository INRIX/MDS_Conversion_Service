package com.inrix.mds;

import com.inrix.mds.constants.MDSConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;
import java.time.Instant;

import static java.time.Instant.now;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebClient
class MdsApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void EventTestHistory(){
		webTestClient.get().uri(MDSConstants.LIVE_API_VERSION + "/events/historical?event_time={event_time}", "2024-05-12T07:58:46.423")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.version").isEqualTo(MDSConstants.LIVE_API_VERSION)
				.jsonPath("$.events").isArray();
	}

	@Test
	void EventTestRecent(){
		Long now = now().toEpochMilli();
		Long weekAgo = Instant.now().minus(Duration.ofDays(7)).toEpochMilli();
		webTestClient.get().uri(MDSConstants.LIVE_API_VERSION + "/events/recent?start_time={start}&end_time={end}", weekAgo, now)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.version").isEqualTo(MDSConstants.LIVE_API_VERSION)
				.jsonPath("$.events").isArray();
	}

	@Test
	void VehicleTestEmpty(){
		webTestClient.get().uri(MDSConstants.LIVE_API_VERSION + "/vehicles")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.version").isEqualTo(MDSConstants.LIVE_API_VERSION)
				.jsonPath("$.vehicle").isArray();
	}


}
