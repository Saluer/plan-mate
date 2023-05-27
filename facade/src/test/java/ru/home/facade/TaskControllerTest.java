package ru.home.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.home.model.Task;
import ru.home.repository.TaskRepository;
import ru.home.security.FullAccessWebSecurityConfig;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = TaskController.class, properties = "security.accessMode=full")
@ContextConfiguration(classes = {TaskController.class, FullAccessWebSecurityConfig.class})
@ActiveProfiles("test")
class TaskControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private TaskRepository taskRepository;


    @Autowired
    TaskControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    void setUp() {
        when(taskRepository.findAll()).thenReturn(List.of(new Task()));
    }

    @Test
    void getMyTasks() throws Exception {
        mockMvc.perform(get("/tasks/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void save() {

    }
}