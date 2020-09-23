package com.ifood.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ifood.ClientApplication;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.ifood.client.document.Client;
import com.ifood.client.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;
import java.util.Collection;
import java.util.List;

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
	
		Collection<Client> nameFilteredClients = clientRepository.findByNameIgnoreCaseContaining("DOE");
		assertEquals(2, nameFilteredClients.size());
	
		Collection<Client> phoneFilteredClients = clientRepository.findByPhoneIgnoreCaseContaining("23458765");
		assertEquals(2, phoneFilteredClients.size());
	
		Collection<Client> emailFilteredClients = clientRepository.findByEmailIgnoreCaseContaining("DOE");
		assertEquals(2, emailFilteredClients.size());
		
		Collection<Client> queryFilteredClients = clientRepository
				.findByNameIgnoreCaseContainingAndPhoneIgnoreCaseContainingAndEmailIgnoreCaseContaining("DOE",
						"12345678", "DOE");
		assertEquals(1, queryFilteredClients.size());
	}

}