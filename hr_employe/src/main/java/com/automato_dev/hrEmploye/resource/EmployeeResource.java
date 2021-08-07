package com.automato_dev.hrEmploye.resource;



import com.automato_dev.hrEmploye.entity.EmployeeEntity;
import com.automato_dev.hrEmploye.repository.EmplolyeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeeResource {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

	
	@Autowired
	private Environment env;
	
	
    @Autowired
    private EmplolyeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Object> fetchAllEmplyoees(){

        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> fetchEmployeeById(@PathVariable("id") Long id){
    	  logger.info("PORTA: "+env.getProperty("local.server.port"));
        return ResponseEntity.ok(employeeRepository.findById(id).orElse(new EmployeeEntity()));
       
    }


    
}
