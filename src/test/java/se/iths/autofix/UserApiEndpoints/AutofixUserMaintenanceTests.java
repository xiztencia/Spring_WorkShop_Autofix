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
class AutofixUserMaintenanceTests {

    @Autowired
    private MockMvc mockMvc;

    //<editor-fold desc="Maintenance API Tests">
    @Test
    void userTrytoAccessMaintenanceFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/maintenance/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    void userTrytoAccessMaintenanceFindAllClientByUsernameReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/maintenance/findallmaintenancessbyclientusername")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    void userTrytoAccessMaintenanceIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/maintenance/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    void userTrytoAccessMaintenanceClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/maintenance/findbyclient/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    void userTrytoDeleteMaintenanceIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/maintenance/delete/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    void userTrytoCreateMaintenanceIdReturnUnauthorized() throws Exception{
        mockMvc.perform(post("/api/maintenance/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":\"Service\"," +
                        "\"price\":2000," +
                        "\"checkInDate\":2020-01-01," +
                        "\"checkOutDate\":2020-01-02}")
        ).andExpect(status().isUnauthorized());
    }
    @Test
    void userTryToGetMaintenanceEmployeeByIdReturnUnauthrized() throws Exception{
        mockMvc.perform(get("/api/maintenance/findallmaintenancesbyemployee/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    void userTrytoFinadAallMaintenanceAllEmployeeByUsernameReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/maintenance/findallmaintenancesbyemployeeusername")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    //</editor-fold>
}
