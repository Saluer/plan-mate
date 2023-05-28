package ru.home.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.home.api.TaskService;
import ru.home.model.Task;
import ru.home.security.FullAccessWebSecurityConfig;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = TaskController.class, properties = "security.accessMode=full")
@ContextConfiguration(classes = {TaskController.class, FullAccessWebSecurityConfig.class})
@ActiveProfiles("test")
class TaskControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    TaskControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    void setUp() {
        when(taskService.findMyTasks(any(String.class))).thenReturn(List.of(new Task()));
        when(taskService.save(Mockito.any(Task.class)))
                .thenAnswer(invocation -> {
                    Task task = invocation.getArgument(0);
                    task.setId(UUID.randomUUID());
                    return task;
                });
    }

    @Test
    @WithMockUser("Alexey")
    void getMyTasks() throws Exception {
        mockMvc.perform(get("/tasks/"))
                .andExpect(status().isOk())
                .andExpect(handler().method(TaskController.class.getMethod("getMyTasks", Authentication.class)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void save() throws Exception {
        mockMvc.perform(put("/tasks/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Smth\"\n" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(handler().method(TaskController.class.getMethod("save", Task.class)))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Smth"));

    }
}