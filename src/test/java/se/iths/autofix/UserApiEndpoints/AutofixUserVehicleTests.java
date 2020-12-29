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
class AutofixUserVehicleTests {

    @Autowired
    private MockMvc mockMvc;

    //<editor-fold desc="Vehicle API Tests">
    @Test

    void userTrytoAccessVehicleFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/vehicle/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }


    @Test

    void userTrytoAccessVehicleIdReturnUnauthorized() throws Exception{
        mockMvc.perform(get("/api/vehicle/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }


    @Test

    void userTrytoDeleteVehicleIdReturnUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/vehicle/delete/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test

    void userTrytoCreateVehicleIdReturnUnauthorized() throws Exception{
        mockMvc.perform(post("/api/vehicle/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"numberPlate\":\"ABC123\"," +
                        "\"maker\":Volvo," +
                        "\"model\":V70}")
        ).andExpect(status().isUnauthorized());
    }


    //</editor-fold>
}
