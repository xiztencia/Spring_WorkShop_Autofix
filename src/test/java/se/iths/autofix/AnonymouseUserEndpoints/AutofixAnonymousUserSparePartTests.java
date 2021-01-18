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
class AutofixAnonymousUserSparePartTests {

    @Autowired
    private MockMvc mockMvc;

    //<editor-fold desc="SparePart API Tests">
    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessSparePartFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/sparepart/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessSparePartFindAllClientByUsernameReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/sparepart/findallsparepartssbyclientusername")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessSparePartIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/sparepart/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoAccessSparePartClientIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/sparepart/findbyclient/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }
    @Test
    @WithAnonymousUser
    void anonymousUserTrytoDeleteSparePartIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/sparepart/delete/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserTrytoCreateSparePartIdReturnUnauthorized() throws Exception{
        mockMvc.perform(post("/api/sparepart/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"part\":\"brake disc\"," +
                        "\"price\":666," +
                        "\"category\":\"Brake System\"," +
                        "\"quantity\":22}")
        ).andExpect(status().isUnauthorized());
    }
    //</editor-fold>
}
