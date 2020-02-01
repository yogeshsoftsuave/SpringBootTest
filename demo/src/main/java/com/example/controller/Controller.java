

package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.model.ModelClass;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class Controller {
	
	Map<Long, ModelClass> map = new HashMap<>();
	
	@GetMapping("/get-all-details")
	public List<ModelClass> getAllDetails(){
		return new ArrayList<ModelClass>(map.values());
	}
	
	@GetMapping("/{id}")
	public ModelClass getDetailById(@PathVariable Long id) {
		return map.get(id);
	}
	
	@PostMapping("/add-details")
	public ModelClass addDetails(@RequestBody ModelClass obj) {
		map.put(obj.getId(), obj);
		return obj;
	}

}
