package se.iths.autofix;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WithMockUser
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixAnonymousUserTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessClientFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/client/findall")
                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isUnauthorized());
    }


    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/client/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoDeleteClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/client/delete/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoCreateClientIdReturnStatusOk() throws Exception{
        mockMvc.perform(post("/api/client/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"kalle\",\"firstname\":\"kalle\",\"lastname\":\"anka\",\"email\":\"anka\",\"password\":\"anka\"}")
        ).andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTryToGetAuthenticatedClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/client/getauthenticatedclient")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessEmployeeFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/employee/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }


    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessEmployeeIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/employee/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoDeleteEmployeeIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/employee/delete/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoCreateEmployeeIdReturnUnauthorized() throws Exception{
        mockMvc.perform(post("/api/employee/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"kalle\"," +
                        "\"firstname\":\"kalle\"," +
                        "\"lastname\":\"anka\"," +
                        "\"email\":\"anka\"," +
                        "\"password\":\"anka\"}")
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTryToGetAuthenticatedEmployeeIdReturnUnauthrized() throws Exception{
        mockMvc.perform(get("/api/employee/getauthenticatedemployee")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessMaintenanceFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/maintenance/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }


    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessMaintenanceIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/maintenance/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoDeleteMaintenanceIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/maintenance/delete/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoCreateMaintenanceIdReturnUnauthorized() throws Exception{
        mockMvc.perform(post("/api/maintenance/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":\"Service\"," +
                        "\"price\":2000," +
                        "\"checkInDate\":2020-01-01," +
                        "\"checkOutDate\":2020-01-02}")
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTryToGetAuthenticatedMaintenanceIdReturnUnauthrized() throws Exception{
        mockMvc.perform(get("/api/maintenance/create")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
}
