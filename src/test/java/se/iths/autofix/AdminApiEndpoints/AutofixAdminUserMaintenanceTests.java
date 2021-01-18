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
import se.iths.autofix.controller.MaintenanceController;
import se.iths.autofix.entity.Maintenance;
import se.iths.autofix.repository.MaintenanceRepository;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringJUnit4ClassRunner.class)
@Import({MaintenanceController.class, AopAutoConfiguration.class})
@WithMockUser(username = "admin", authorities = { "ADMIN"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixAdminUserMaintenanceTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MaintenanceRepository repository;

    @BeforeEach
    void init(){
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.findById(1L)).thenReturn(Optional.of(new Maintenance("Service", 2000, new Date(2020-01-01), new Date(2020-01-02))));
    }
    //<editor-fold desc="Maintenance API Tests">
    @Test

    void adminUserTrytoAccessMaintenanceFindAllReturnOk() throws Exception{
        mockMvc.perform(get("/api/maintenance/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test

    void adminUserTrytoAccessMaintenanceFindAllClientByUsernameReturnOk() throws Exception{
        mockMvc.perform(get("/api/maintenance/findallmaintenancesbyclientusername")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
    @Test

    void adminUserTrytoAccessMaintenanceIdReturnOk() throws Exception{
        mockMvc.perform(get("/api/maintenance/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test

    void adminUserTrytoAccessMaintenanceClientIdReturnOk() throws Exception{
        mockMvc.perform(get("/api/maintenance/findbyclient/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
    @Test

    void adminUserTrytoDeleteMaintenanceIdReturnOk() throws Exception{
        mockMvc.perform(delete("/api/maintenance/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test

    void adminUserTrytoCreateMaintenanceIdReturnOk() throws Exception{
        mockMvc.perform(post("/api/maintenance/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":\"Service\","+
                        "\"price\":2000," +
                        "\"checkInDate\":\"2020-01-01\"," +
                        "\"checkOutDate\":\"2020-12-31\"}")
        ).andExpect(status().isOk());
    }
    //</editor-fold>
}
