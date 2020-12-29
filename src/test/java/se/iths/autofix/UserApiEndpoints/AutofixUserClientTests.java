package se.iths.autofix.UserApiEndpoints;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.autofix.controller.ClientController;
import se.iths.autofix.entity.Client;
import se.iths.autofix.repository.ClientRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringJUnit4ClassRunner.class)
@Import({ClientController.class,AopAutoConfiguration.class})
@WithMockUser(username = "user", authorities = { "USER"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixUserClientTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository repository;

    @BeforeAll
    void init(){
        repository.save(new Client("user","user1","user1","user1","user1"));
    }


    //<editor-fold desc="Client API Tests">
    @Test
    void userTrytoAccessClientFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/client/findall")
                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isForbidden());
    }


    @Test
    void userTrytoAccessClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/client/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void userTrytoDeleteClientIdReturnUnauthorized() throws Exception{

        mockMvc.perform(delete("/api/client/delete/1/")
        ).andExpect(status().isOk());
    }

    @Test
    void userTrytoCreateClientIdReturnStatusOk() throws Exception{
        mockMvc.perform(post("/api/client/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"kalle\",\"firstname\":\"kalle\",\"lastname\":\"anka\",\"email\":\"anka\",\"password\":\"anka\"}")
        ).andExpect(status().isOk());
    }

    @Test
    void userTryToGetAuthenticatedClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/client/getauthenticatedclient")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
    //</editor-fold>

}
