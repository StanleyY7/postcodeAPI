package postcode.project.backend.postcodes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/postcode")
public class PostCodeController {

	@Autowired
	private PostCodeService postCodeService;
	
	// Constructor 
	public PostCodeController(PostCodeService postCodeService) {
		this.postCodeService = postCodeService;
	}
	
	@PostMapping
	public ResponseEntity<PostCode> createPostCode(@Valid @RequestBody CreatePostCodeDto data) {
	PostCode createdPostCode = this.postCodeService.create(data);
	return new ResponseEntity<>(createdPostCode, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PostCode>> findAll(){
		List<PostCode> allPostCodes = this.postCodeService.findAll();
		return new ResponseEntity<>(allPostCodes, HttpStatus.OK);
	}
	
	@GetMapping("/{areaCode}")
	public ResponseEntity<PostCode> findByAreaCode(@PathVariable Long areaCode){
		Optional<PostCode> maybePostCode = this.postCodeService.findByAreaCode(areaCode);
		
		if(maybePostCode.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(maybePostCode.get(), HttpStatus.OK);
	}
	
	@GetMapping("/suburb:{suburb}")
	public ResponseEntity<PostCode> getBySuburb(@PathVariable String suburb){
		Optional<PostCode> maybePostCode = this.postCodeService.findBySuburb(suburb);
		
		if(maybePostCode.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(maybePostCode.get(), HttpStatus.OK);
	}
	

	}

	



