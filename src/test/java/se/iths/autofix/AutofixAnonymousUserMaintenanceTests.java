package se.iths.autofix;

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
class AutofixAnonymousUserMaintenanceTests {

    @Autowired
    private MockMvc mockMvc;

    //<editor-fold desc="Maintenance API Tests">
    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessMaintenanceFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/maintenance/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessMaintenanceFindAllClientByUsernameReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/maintenance/findallmaintenancessbyclientusername")
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
    void anonymousUserTrytoAccessMaintenanceClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/maintenance/findbyclient/1")
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
    void anonymousUserTryToGetMaintenanceEmployeeByIdReturnUnauthrized() throws Exception{
        mockMvc.perform(get("/api/maintenance/findallmaintenancesbyemployee/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    @WithAnonymousUser
    void anonymousUserTrytoFinadAallMaintenanceAllEmployeeByUsernameReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/maintenance/findallmaintenancesbyemployeeusername")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    //</editor-fold>
}
