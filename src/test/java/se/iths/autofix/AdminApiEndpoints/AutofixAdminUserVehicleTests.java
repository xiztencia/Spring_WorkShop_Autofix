package se.iths.autofix.AdminApiEndpoints;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.autofix.controller.VehicleController;
import se.iths.autofix.entity.Vehicle;
import se.iths.autofix.repository.VehicleRepository;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringJUnit4ClassRunner.class)
@Import({VehicleController.class, AopAutoConfiguration.class})
@WithMockUser(username = "admin", authorities = { "ADMIN"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixAdminUserVehicleTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleRepository repository;

    @BeforeEach
    void init(){
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.findById(1L)).thenReturn(Optional.of(new Vehicle("ABC123", "Volvo", "V70")));
    }
    //<editor-fold desc="Vehicle API Tests">
    @Test
    void adminUserTrytoAccessVehicleFindAllReturnOk() throws Exception{
        mockMvc.perform(get("/api/vehicle/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void adminUserTrytoAccessVehicleIdReturnOk() throws Exception{
        mockMvc.perform(get("/api/vehicle/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void adminUserTrytoDeleteVehicleIdReturnOk() throws Exception{
        mockMvc.perform(delete("/api/vehicle/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void adminUserTrytoCreateVehicleIdReturnOk() throws Exception{
        mockMvc.perform(post("/api/vehicle/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"numberPlate\":\"ABC123\"," +
                        "\"maker\":\"Volvo\"," +
                        "\"model\":\"V70\"}")
        ).andExpect(status().isOk());
    }
    //</editor-fold>
}
