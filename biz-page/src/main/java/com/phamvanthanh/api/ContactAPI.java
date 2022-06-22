package com.phamvanthanh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phamvanthanh.dto.ContactDTO;
import com.phamvanthanh.service.IContactService;

@RestController
public class ContactAPI {
	
	@Autowired
	private IContactService contactService;
	
	@PutMapping(value = "/api/contact/{id}", produces = "application/json")
	public ContactDTO updateContactDTO(@RequestBody ContactDTO model,@PathVariable(value="id",required = false) Long id) {
		ContactDTO contactDTO = new ContactDTO();
		contactDTO = contactService.save(model);
		return contactDTO;
	}
	@DeleteMapping(value = "/api/contact/{id}")
	public boolean deleteContactDTO(@PathVariable(value="id",required = false) Long id) {
		boolean deleteConfirm = false;
		deleteConfirm = contactService.delete(id);
		return deleteConfirm;
	}
}
