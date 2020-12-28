package se.iths.autofix.UserApiEndpoints;

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
@WithMockUser(username = "user", authorities = { "USER"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixUserEmployeeTests {

    @Autowired
    private MockMvc mockMvc;

    //<editor-fold desc="Employee API Tests">
    @Test

    void userTrytoAccessEmployeeFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/employee/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }


    @Test

    void userTrytoAccessEmployeeIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/employee/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void userTrytoDeleteEmployeeIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/employee/delete/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void userTrytoCreateEmployeeIdReturnUnauthorized() throws Exception{
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

    void userTryToGetAuthenticatedEmployeeIdReturnUnauthrized() throws Exception{
        mockMvc.perform(get("/api/employee/getauthenticatedemployee")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    //</editor-fold>

}
