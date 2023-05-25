package ru.home.facade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.home.repository.TaskRepository;
import ru.home.security.FullAccessWebSecurityConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = TaskController.class, properties = "security.accessMode=full")
@ContextConfiguration(classes = {TaskRepository.class, FullAccessWebSecurityConfig.class})
class TaskControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    TaskControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void getMyTasks() throws Exception {
        mockMvc.perform(get("/tasks/")).andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    void save() {
    }
}