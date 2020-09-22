package com.ifood.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
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

	@BeforeAll
	public void setup() {
		clientRepository.save(new Client("John Doe", "john@doe.com", "12345678"));
		clientRepository.save(new Client("Mary Doe", "mary@doe.com", "12348765"));
		clientRepository.save(new Client("Billy Bob", "billy@bob.com", "23458765"));
		clientRepository.save(new Client("Betty Boo", "betty@boo.com", "23458765"));
	}
	
	@Test
	public void shouldQueryAllClients() {
		clientRepository.save(new Client("John Doe", "john@doe.com", "12345678"));
		clientRepository.save(new Client("Mary Doe", "mary@doe.com", "12348765"));
		clientRepository.save(new Client("Billy Bob", "billy@bob.com", "23458765"));
		clientRepository.save(new Client("Betty Boo", "betty@boo.com", "23458765"));
		
		List<Client> clients = clientRepository.findAll();
		Assertions.assertEquals(4, clients.size());
	}
	
	@Test
	public void shouldFilterClientsByName() {
		Collection<Client> nameFilteredClients = clientRepository.findByNameIgnoreCaseContaining("doe");
		Assertions.assertEquals(2, nameFilteredClients.size());
	}
	
	@Test
	public void shouldFilterClientsByPhone() {
		Collection<Client> nameFilteredClients = clientRepository.findByPhoneIgnoreCaseContaining("23458765");
		Assertions.assertEquals(2, nameFilteredClients.size());
	}
	
	@Test
	public void shouldFilterClientsByEmail() {
		Collection<Client> nameFilteredClients = clientRepository.findByEmailIgnoreCaseContaining("doe");
		Assertions.assertEquals(2, nameFilteredClients.size());
	}

}