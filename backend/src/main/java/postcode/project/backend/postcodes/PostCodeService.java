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
		PostCode newPostCode = mapper.map(data, PostCode.class);
		return this.postCodeRepository.save(newPostCode);
	}
	
	public List<PostCode> findAll(){
		return this.postCodeRepository.findAll();
	}

	public Optional<PostCode> findByAreaCode(Long areaCode) {
		// TODO Auto-generated method stub
		return this.postCodeRepository.findByAreaCode(areaCode);
	}
	
	public Optional<PostCode> findBySuburb(String suburb) {
		// TODO Auto-generated method stub
		return this.postCodeRepository.findBySuburb(suburb);
	}


}
