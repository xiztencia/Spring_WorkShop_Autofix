package se.iths.autofix.AdminApiEndpoints;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.autofix.controller.ClientController;
import se.iths.autofix.entity.Client;
import se.iths.autofix.repository.ClientRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringJUnit4ClassRunner.class)
@Import({ClientController.class, AopAutoConfiguration.class})
@WithMockUser(username = "admin", authorities = { "ADMIN"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixAdminUserClientTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientRepository repository;

    @BeforeEach
    void init(){
        when(repository.findById(1L)).thenReturn(Optional.of(new Client("user1","user11","user11","user11","user11")));
    }

    //<editor-fold desc="Client API Tests">
    @Test
    void adminUserTrytoAccessClientFindAllReturnOk() throws Exception{
        mockMvc.perform(get("/api/client/findall")
                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk());
    }

    @Test
    void adminUserTrytoAccessClientIdReturnOk() throws Exception{
        mockMvc.perform(get("/api/client/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void adminUserTrytoDeleteClientIdReturnOk() throws Exception{
        mockMvc.perform(delete("/api/client/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void adminUserTrytoCreateClientIdReturnStatusOk() throws Exception{
        mockMvc.perform(post("/api/client/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"kalle\",\"firstname\":\"kalle\",\"lastname\":\"anka\",\"email\":\"anka\",\"password\":\"anka\"}")
        ).andExpect(status().isOk());
    }

    @Test
    void adminUserTryToGetAuthenticatedClientIdReturnOk() throws Exception{
        mockMvc.perform(get("/api/client/getauthenticatedclient")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
    //</editor-fold>
}
