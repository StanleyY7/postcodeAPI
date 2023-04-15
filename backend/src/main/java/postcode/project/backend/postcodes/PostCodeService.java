package postcode.project.backend.postcodes;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostCodeService {
	
	@Autowired
	private PostCodeRepository postCodeRepository;
	
	@Autowired
	private ModelMapper mapper;

	public PostCode create(CreatePostCodeDto data) {	
		
		// Check if suburb already exists as suburbs can only have one postcode
		
		Optional<PostCode> maybeSuburb = this.postCodeRepository.findBySuburb(data.getSuburb());
		if (maybeSuburb.isPresent()) {
			throw new IllegalArgumentException("Suburb already exists with a postcode");
		}
		
		// Check if the postcode and suburb combination already exists
		Optional<PostCode> maybePostCode = this.postCodeRepository.findByAreaCodeAndSuburb(data.getAreaCode(), data.getSuburb());
		if (maybePostCode.isPresent()) {
			throw new IllegalArgumentException("Postcode and suburb combination already exists");
		}


		PostCode newPostCode = mapper.map(data, PostCode.class);
		return this.postCodeRepository.save(newPostCode);
	}
	
	public List<PostCode> findAll(){
		return this.postCodeRepository.findAll();
	}

	public List<PostCode> findByAreaCode(Long areaCode) {
	    return this.postCodeRepository.findByAreaCode(areaCode);
	}

	public Optional<PostCode> findBySuburb(String suburb) {
		return this.postCodeRepository.findBySuburb(suburb);
	}


}
