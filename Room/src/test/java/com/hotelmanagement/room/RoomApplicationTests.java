package com.hotelmanagement.room;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RoomApplicationTests {

	
	@Test
	void contextLoads() {
		boolean s=true;
		assertEquals(true,s);
	}

}
