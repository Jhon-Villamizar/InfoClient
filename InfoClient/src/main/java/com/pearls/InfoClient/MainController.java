package com.pearls.InfoClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
class MainController {
	@Autowired 
	private final ClientRepository repository;
	
	MainController(ClientRepository repository) {
	    this.repository = repository;
	}
	
	// Aggregate root
	
	@GetMapping("/all")
	List<Client> all() {
		return repository.findAll();
	}
	
	@PostMapping("/add")
	Client newClient(@RequestBody Client newClient) {
	    return repository.save(newClient);
	}

	@PutMapping("/client/{id}") 
	Client replaceClient (@RequestBody Client newClient,@PathVariable Long id) {

		return repository.findById(id)
			.map(client -> {
				client.setDescription(newClient.getDescription());
				client.setNit(newClient.getNit());
				client.setFullname(newClient.getFullname());
				client.setAdress(newClient.getAdress());
				client.setPhone(newClient.getPhone());
				client.setCity(newClient.getCity());
				client.setState(newClient.getState());
				client.setCountry(newClient.getCountry());
				client.setCreditlim(newClient.getCreditlim());
				client.setAvalcredit(newClient.getAvalcredit());
				client.setDate(newClient.getDate());
				client.setRepresentative(newClient.getRepresentative());
				client.setVisit(newClient.getVisit());
				client.setDescVisit(newClient.getDescVisit());
				return repository.save(client);
			})
			.orElseGet(() -> {
				newClient.setId(id);
				return repository.save(newClient);
			});
	}
	
	@DeleteMapping("/client/{id}")
	void deleteClient(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
