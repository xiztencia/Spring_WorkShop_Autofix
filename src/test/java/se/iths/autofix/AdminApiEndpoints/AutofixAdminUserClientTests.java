package se.iths.autofix.AdminApiEndpoints;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Disabled
@RunWith(SpringJUnit4ClassRunner.class)
@WithMockUser(username = "admin", authorities = { "ADMIN"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixAdminUserClientTests {

    @Autowired
    private MockMvc mockMvc;

    //<editor-fold desc="Client API Tests">
    @Test

    void adminUserTrytoAccessClientFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/client/findall")
                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isUnauthorized());
    }


    @Test

    void adminUserTrytoAccessClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/client/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void adminUserTrytoDeleteClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/client/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void adminUserTrytoCreateClientIdReturnStatusOk() throws Exception{
        mockMvc.perform(post("/api/client/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"kalle\",\"firstname\":\"kalle\",\"lastname\":\"anka\",\"email\":\"anka\",\"password\":\"anka\"}")
        ).andExpect(status().isOk());
    }

    @Test

    void adminUserTryToGetAuthenticatedClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/client/getauthenticatedclient")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    //</editor-fold>

}
