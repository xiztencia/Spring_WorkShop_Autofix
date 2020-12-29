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
class AutofixAdminUserSparePartTests {

    @Autowired
    private MockMvc mockMvc;

    //<editor-fold desc="SparePart API Tests">
    @Test

    void adminUserTrytoAccessSparePartFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/sparepart/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void adminUserTrytoAccessSparePartFindAllClientByUsernameReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/sparepart/findallsparepartssbyclientusername")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test

    void adminUserTrytoAccessSparePartIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/sparepart/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void adminUserTrytoAccessSparePartClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/sparepart/findbyclient/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test

    void adminUserTrytoDeleteSparePartIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/sparepart/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void adminUserTrytoCreateSparePartIdReturnUnauthorized() throws Exception{
        mockMvc.perform(post("/api/sparepart/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"part\":\"brake disc\"," +
                        "\"price\":666," +
                        "\"category\":\"Brake System\"," +
                        "\"quantity\":22}")
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void adminUserTryToGetSparePartEmployeeByIdReturnUnauthrized() throws Exception{
        mockMvc.perform(get("/api/sparepart/findallsparepartsbyemployee/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test

    void adminUserTrytoFinadAallSparePartAllEmployeeByUsernameReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/sparepart/findallsparepartsbyemployeeusername")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    //</editor-fold>
}
