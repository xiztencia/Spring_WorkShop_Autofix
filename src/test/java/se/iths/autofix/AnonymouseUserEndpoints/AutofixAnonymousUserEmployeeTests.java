package se.iths.autofix.AnonymouseUserEndpoints;

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
@RunWith(SpringJUnit4ClassRunner.class)
@WithMockUser
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixAnonymousUserEmployeeTests {

    @Autowired
    private MockMvc mockMvc;

    //<editor-fold desc="Employee API Tests">
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
    //</editor-fold>

}
