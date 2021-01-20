package se.iths.autofix.UserApiEndpoints;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.autofix.controller.EmployeeController;
import se.iths.autofix.entity.Employee;
import se.iths.autofix.repository.EmployeeRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringJUnit4ClassRunner.class)
@Import({EmployeeController.class, AopAutoConfiguration.class})
@WithMockUser(username = "user", authorities = { "USER"})
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class AutofixUserEmployeeTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository repository;

    @BeforeAll
    void init(){
        repository.save(new Employee("user","user1","user1","user1","user1"));
    }

    //<editor-fold desc="Employee API Tests">
    @Test
    void userTrytoAccessEmployeeFindAllReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/employee/findall")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isForbidden());
    }
    @Test
    void userTrytoAccessEmployeeIdReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/employee/id/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isForbidden());
    }
    @Test
    void userTrytoDeleteEmployeeIdReturnForbidden() throws Exception{
        mockMvc.perform(delete("/api/employee/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isForbidden());
    }
    @Test
    void userTrytoCreateEmployeeIdReturnForbidden() throws Exception{
        mockMvc.perform(post("/api/employee/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"kalle\"," +
                        "\"firstname\":\"kalle\"," +
                        "\"lastname\":\"anka\"," +
                        "\"email\":\"anka\"," +
                        "\"password\":\"anka\"}")
        ).andExpect(status().isForbidden());
    }
    @Test
    void userTryToGetAuthenticatedEmployeeIdReturnForbidden() throws Exception{
        mockMvc.perform(get("/api/employee/getauthenticatedemployee")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isForbidden());
    }
    //</editor-fold>
}
