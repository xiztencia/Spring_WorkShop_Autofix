package se.iths.autofix.AdminApiEndpoints;

import org.junit.jupiter.api.*;
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
import se.iths.autofix.controller.ClientController;
import se.iths.autofix.controller.EmployeeController;
import se.iths.autofix.entity.Client;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.repository.ClientRepository;
import se.iths.autofix.repository.EmployeeRepository;
import se.iths.autofix.service.EmployeeService;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringJUnit4ClassRunner.class)
@Import({EmployeeController.class, AopAutoConfiguration.class})
@WithMockUser(username = "admin", authorities = { "ADMIN"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixAdminUserEmployeeTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository repository;

    @BeforeEach
    void init(){
        when(repository.findById(1L)).thenReturn(Optional.of(new Employee("user2","user12","user12","user12","user12")));
        when(repository.findById(3L)).thenReturn(Optional.of(new Employee("user2","user12","user12","user12","user12")));
        doNothing().when(repository).deleteById(3L);
    }

    //<editor-fold desc="Employee API Tests">
    @Test
    void adminUserTrytoAccessEmployeeFindAllReturnOK() throws Exception{

        mockMvc.perform(get("/api/employee/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

    }

    @Test
    void adminUserTrytoAccessEmployeeIdReturnOK() throws Exception{
     //   EmployeeService mockEmployeeService = mock(EmployeeService.class);
        mockMvc.perform(get("/api/employee/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    //    System.out.println( verify(mockEmployeeService,times(1)).findEmployeeById(1L));
    }

    @Test
    void adminUserTrytoDeleteEmployeeIdReturnOK() throws Exception{
        mockMvc.perform(delete("/api/employee/delete/3")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void adminUserTrytoCreateEmployeeIdReturnOK() throws Exception{
        mockMvc.perform(post("/api/employee/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"kalle\"," +
                        "\"firstname\":\"kalle\"," +
                        "\"lastname\":\"anka\"," +
                        "\"email\":\"anka\"," +
                        "\"password\":\"anka\"}")
        ).andExpect(status().isOk());
    }

    @Test
    void adminUserTryToGetAuthenticatedEmployeeIdReturnOK() throws Exception{
        mockMvc.perform(get("/api/employee/getauthenticatedemployee")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
    //</editor-fold>
}
