package mr.esp.springdemo;

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

import mr.esp.springdemo.EspTemplateSpringApplication;
import mr.esp.springdemo.repository.EtudiantRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EspTemplateSpringApplication.class)
class EspTemplateSpringApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;

	@Resource
    private EtudiantRepository mockEtudiantRepository;
    
	@Test
	void contextLoads() {
		assertThat(mockEtudiantRepository).isNotNull();
	}
	
	
	@Test
	public void addEtudiantTestOk() throws Exception {
        
		JSONObject p = new JSONObject();
		p.put("nom", "Sidi");
		p.put("prenom", "Mohamed");
		p.put("dateDeNaissance", "11-11-2001");
		p.put("matricule", "1255");

		MockMultipartFile etudiantData = new MockMultipartFile("etudiant", "etudiant", MediaType.APPLICATION_JSON_VALUE,
				p.toString().getBytes(StandardCharsets.UTF_8));

		mockMvc.perform(multipart("/etudiant/add").file(etudiantData))
				.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.nom", is("Sidi")))
                .andExpect(jsonPath("$.prenom", is("Mohamed")))
                .andExpect(jsonPath("$.matricule", is("1255")))
                .andExpect(jsonPath("$.dateDeNaissance", is("2001-11-11T00:00:00.000+0000")));

	}
	 

}
