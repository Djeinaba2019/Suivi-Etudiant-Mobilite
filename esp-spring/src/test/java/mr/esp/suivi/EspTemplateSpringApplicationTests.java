package mr.esp.suivi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import mr.esp.suivi.EspTemplateSpringApplication;
import mr.esp.suivi.repository.StudentRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EspTemplateSpringApplication.class)
class EspTemplateSpringApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;

	@Resource
    private StudentRepository mockPatientRepository;
    
	@Test
	void contextLoads() {
		assertThat(mockPatientRepository).isNotNull();
	}
	
	
	@Test
	public void addPatientTestOk() throws Exception {
        
		JSONObject p = new JSONObject();
		p.put("name", "Sidi");
		p.put("surname", "Mohamed");
		p.put("dateOfBirth", "11-11-2001");

		MockMultipartFile studentData = new MockMultipartFile("student", "student", MediaType.APPLICATION_JSON_VALUE,
				p.toString().getBytes(StandardCharsets.UTF_8));

		mockMvc.perform(multipart("/patient/add").file(studentData))
				.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name", is("Sidi")))
                .andExpect(jsonPath("$.surname", is("Mohamed")))
                .andExpect(jsonPath("$.dateOfBirth", is("2001-11-11T00:00:00.000+0000")));

	}
	 

}
