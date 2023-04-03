package postcode.project.backend.tests;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PostCodeServiceTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCreatePostCodeWithCorrectDetails() throws Exception {
        String json = "{\"suburb\": \"Example\", \"areaCode\": 2000, \"state\": \"NSW\"}";

        mvc.perform(post("/postcode")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .with(httpBasic("admin", "password")))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.suburb").value("Example"))
                .andExpect(jsonPath("$.areaCode").value(2000))
                .andExpect(jsonPath("$.state").value("NSW"));
    }
    
    @Test
    public void testIncorrectCredentials() throws Exception{
    	String json = "{\"suburb\": \"Example\", \"areaCode\": 2000, \"state\": \"NSW\"}";
    	
    	mvc.perform(post("/postcode")
        .contentType(MediaType.APPLICATION_JSON)
    	.content(json)
    	.with(httpBasic("user","wrongPassword")))
		.andExpect(status().isUnauthorized())
		.andExpect(jsonPath("$.suburb").doesNotExist())
		.andExpect(jsonPath("$.areaCode").doesNotExist())
		.andExpect(jsonPath("$.state").doesNotExist());
    }
    
    @Test
    public void testCorrectCredentialsButWrongValues() throws Exception{
    	String json = "{\"suburb\": \"Example\", \"areaCode\": , \"state\": \"NSW\"}";
    	
    	mvc.perform(post("/postcode")
        .contentType(MediaType.APPLICATION_JSON)
    	.content(json)
    	.with(httpBasic("admin","password")))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.suburb").doesNotExist())
		.andExpect(jsonPath("$.areaCode").doesNotExist())
		.andExpect(jsonPath("$.state").doesNotExist());
    }
}
