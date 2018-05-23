package tr.com.dev.haliYikama.server.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tr.com.dev.haliYikama.server.service.interfaces.IAdresService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdresController.class)
@ActiveProfiles("testProfile")
public class AdresControllerTest {
    @MockBean
    IAdresService adresServiceMock;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() {

    }

    @Test
    public void getAllAdres() {
        try {
            //  RAuthentication.getAuthTokenCookie()
            mockMvc.perform(get("/address/getAll")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}