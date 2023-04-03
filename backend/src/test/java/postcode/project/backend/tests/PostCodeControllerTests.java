package postcode.project.backend.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import postcode.project.backend.postcodes.PostCode;
import postcode.project.backend.postcodes.PostCodeController;
import postcode.project.backend.postcodes.PostCodeService;

@ExtendWith(SpringExtension.class)
public class PostCodeControllerTests {
    private MockMvc mockMvc;
    
    @Mock
    private PostCodeService postCodeService;
    
    @InjectMocks
    private PostCodeController postCodeController;
    
    @BeforeEach
    public void setUp() {
    	
        mockMvc = MockMvcBuilders.standaloneSetup(postCodeController).build();
        new ObjectMapper();
        
    }
    
    @Test
    public void testGetStatusFindAll() throws Exception {
    	
    	mockMvc.perform(get("/postcode")).andExpect(status().isOk());
    	
    }
    
    @Test
    public void testFindAll() {
    	
    	List<PostCode> postCodes = new ArrayList<PostCode>();
    	
    	postCodes.add(new PostCode(1L, "Example", 2000L, "NSW"));
    	postCodes.add(new PostCode(2L, "Example2", 3000L, "NSW"));
    	
    	PostCodeService postCodeService = mock(PostCodeService.class);
    	
        when(postCodeService.findAll()).thenReturn(postCodes);
        
        PostCodeController postCodeController = new PostCodeController(postCodeService);
        
        ResponseEntity<List<PostCode>> response = postCodeController.findAll();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(postCodes, response.getBody());
        
    }
        
    @Test
    public void testFindBySuburb() {
    	
    	List<PostCode> postCodes = new ArrayList<PostCode>();
    	postCodes.add(new PostCode(1L,"Example", 2000L, "NSW"));
    	postCodes.add(new PostCode(1L,"Example2", 3000L, "NSW"));
    	
    	PostCodeService postCodeService = mock(PostCodeService.class);
    	
    	when(postCodeService.findBySuburb("Example")).thenReturn(Optional.of(postCodes.get(0)));
    	
    	PostCodeController postCodeController = new PostCodeController(postCodeService);
    	
    	ResponseEntity<PostCode> response = postCodeController.getBySuburb("Example");
    	
    	assertEquals(HttpStatus.OK, response.getStatusCode());
    	assertEquals(postCodes.get(0), response.getBody());
    }
    
    
    @Test
    public void testFindByAreaCode() {
    	
    	List<PostCode> postCodes = new ArrayList<PostCode>();
    	postCodes.add(new PostCode(1L, "Example", 2000L, "NSW"));
    	postCodes.add(new PostCode(2L, "Example2", 3000L, "NSW"));
    	
    	PostCodeService postCodeService = mock(PostCodeService.class);
    	
    	when(postCodeService.findByAreaCode(2000L)).thenReturn(Optional.of(postCodes.get(0)));
    	
    	PostCodeController postCodeController = new PostCodeController(postCodeService);
    	
    	ResponseEntity<PostCode> response = postCodeController.findByAreaCode(2000L);
    	
    	assertEquals(HttpStatus.OK, response.getStatusCode());
    	assertEquals(postCodes.get(0), response.getBody());

    }
}
