package postcode.project.backend.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import postcode.project.backend.BackendApplication;
import postcode.project.backend.postcodes.CreatePostCodeDto;
import postcode.project.backend.postcodes.PostCode;
import postcode.project.backend.postcodes.PostCodeRepository;
import postcode.project.backend.postcodes.PostCodeService;

@SpringBootTest(classes=BackendApplication.class)
public class PostCodeServiceTests {

	@Mock
	private PostCodeRepository postCodeRepository;

	@InjectMocks
	private PostCodeService postCodeService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testCreatePostCode() {
		CreatePostCodeDto postCodeDto = new CreatePostCodeDto();
		postCodeDto.setSuburb("Example");
		postCodeDto.setAreaCode((long) 2000);
		postCodeDto.setState("NSW");
		
        when(postCodeRepository.save(Mockito.any(PostCode.class))).thenAnswer(invocation -> {
            PostCode postCode = invocation.getArgument(0);
            postCode.setId(1L); // set the id to simulate the creation of a new post
            return postCode;
        });
        
        PostCode createdPostCode = postCodeService.create(postCodeDto);
        assertThat(createdPostCode).isNotNull();
        assertThat(createdPostCode.getSuburb()).isEqualTo("Example");
        assertThat(createdPostCode.getAreaCode()).isEqualTo((long) 2000);
        assertThat(createdPostCode.getState()).isEqualTo("NSW");
        
        verify(postCodeRepository, times(1)).save(createdPostCode);
	}
	
	@Test
	public void testNullPost() {
		CreatePostCodeDto postCodeDto = new CreatePostCodeDto();
		postCodeDto.setSuburb(null);
		postCodeDto.setState(null);
		postCodeDto.setAreaCode((long)2000);
		
		assertThrows(NullPointerException.class, () -> postCodeService.create(postCodeDto));
	}
}
