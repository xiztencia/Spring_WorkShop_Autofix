package se.iths.autofix.UserApiEndpoints;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.autofix.controller.SparePartController;
import se.iths.autofix.entity.Client;
import se.iths.autofix.entity.SparePart;
import se.iths.autofix.repository.SparePartRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringJUnit4ClassRunner.class)
@Import({SparePartController.class, AopAutoConfiguration.class})
@WithMockUser(username = "user", authorities = { "USER"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixUserSparePartTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SparePartRepository repository;
    //<editor-fold desc="SparePart API Tests">

    @BeforeEach
    void init(){
        Client client = new Client("Kalle","Kalle","Anka","kalle@anka.com","kajsa");
        SparePart sparepart = new SparePart("Brake System", "brake disc", 666, 22);
        SparePart sparepart1 = new SparePart("Brake System2", "brake disc2", 666, 22);
        sparepart.setClient(client);
        sparepart1.setClient(client);
        when(repository.findAllSparePartsByClientUsername("Kalle")).thenReturn(Arrays.asList(sparepart,sparepart1));
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.findById(1L)).thenReturn( Optional.of(sparepart));
    }
    //<editor-fold desc="SparePart API Tests">
    @Test
    void userTrytoAccessSparePartFindAllReturnOk() throws Exception{
        mockMvc.perform(get("/api/sparepart/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void userTrytoAccessSparePartFindAllClientByUsernameReturnOk() throws Exception{
        mockMvc.perform(get("/api/sparepart/findallsparepartsbyclientusername/Kalle")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void userTrytoAccessSparePartIdReturnOk() throws Exception{
        mockMvc.perform(get("/api/sparepart/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void userTrytoAccessSparePartClientIdReturnOk() throws Exception{
        mockMvc.perform(get("/api/sparepart/findbyclient/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void userTrytoDeleteSparePartIdReturnForbidden() throws Exception{
        mockMvc.perform(delete("/api/sparepart/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isForbidden());
    }

    @Test
    void userTrytoCreateSparePartIdReturnForbidden() throws Exception{
        mockMvc.perform(post("/api/sparepart/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"part\":\"brake disc\"," +
                        "\"price\":666," +
                        "\"category\":\"Brake System\"," +
                        "\"quantity\":22}")
        ).andExpect(status().isForbidden());
    }

    @Test
    void userTryToGetSparePartEmployeeByIdReturnOk() throws Exception{
        mockMvc.perform(get("/api/sparepart/findallsparepartsbyemployee/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void userTrytoFinadAallSparePartAllEmployeeByUsernameReturnOk() throws Exception{
        mockMvc.perform(get("/api/sparepart/findallsparepartsbyemployeeusername")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
    //</editor-fold>
}
