package postcode.project.backend.postcodes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostCodeService {
	
	@Autowired
	private PostCodeRepository postCodeRepository;

	public PostCode create(CreatePostCodeDto data) {
		String PostSuburb = data.getSuburb().trim();
		Long PostAreaCode = data.getAreaCode();
		String PostState = data.getState().trim().toUpperCase();
		
		PostCode newPostCode = new PostCode();
		
		newPostCode.setSuburb(PostSuburb);
		newPostCode.setAreaCode(PostAreaCode);
		newPostCode.setState(PostState);
		
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
