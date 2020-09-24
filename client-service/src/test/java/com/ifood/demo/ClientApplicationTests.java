package com.ifood.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ifood.client.document.Client;
import com.ifood.client.document.QClient;
import com.ifood.client.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Collection;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Autowired
	ClientRepository clientRepository;
	
	@Test
	public void clientServiceTest() {
		clientRepository.save(new Client("John Doe", "john@doe.com", "12345678"));
		clientRepository.save(new Client("Mary Doe", "mary@doe.com", "12348765"));
		clientRepository.save(new Client("Billy Bob", "billy@bob.com", "23458765"));
		clientRepository.save(new Client("Betty Boo", "betty@boo.com", "23458765"));
		
		Iterable<Client> clients = clientRepository.findAll();
		int clientsCount = 0;
		for (Client client : clients) {
			clientsCount++;
		}
		assertEquals(4, clientsCount);
	}

}