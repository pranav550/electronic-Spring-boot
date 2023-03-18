package com.lcwd.electronic.store.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcwd.electronic.store.dtos.PageableResponse;
import com.lcwd.electronic.store.dtos.UserDto;
import com.lcwd.electronic.store.entities.Role;
import com.lcwd.electronic.store.entities.User;
import com.lcwd.electronic.store.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Set;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @MockBean
    private UserService userService;

    User user;
    Role role;
    String roleId;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){

        role= Role.builder()
                .roleId("abc")
                .roleName("NORMAL")
                .build();


        user = User.builder()
                .name("pranav")
                .email("pranav@gmail.com")
                .about("this is testing about create method")
                .gender("Male")
                .imageName("abc.png")
                .password("123456")
                .roles(Set.of(role))
                .build();

    }

    @Test
    public void createUserTest() throws Exception {
        // /users +POST +user data from json
        // data as json + status created
        UserDto dto = mapper.map(user, UserDto.class);

        Mockito.when(userService.createUser(Mockito.any())).thenReturn(dto);

        // actual request for url
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(convertObjectToJsonString(user))
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.name").exists());


    }

    @Test
    public void updateUserTest() throws Exception {
        // /users/{userId} +put request + json

        String userId = "123";
        UserDto dto = this.mapper.map(user, UserDto.class);
        Mockito.when(userService.updateUser(Mockito.any(),Mockito.anyString())).thenReturn(dto);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/users/"+userId)
                                .header(HttpHeaders.AUTHORIZATION,"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcmFuYXZAZGV2LmluIiwiaWF0IjoxNjc5MTYxNjg3LCJleHAiOjE2NzkxNzk2ODd9.H3sYybtjvrwwuu8Ue7nLsmWQdBmoScIPxVdFwgpGOsNamY2UJPyK4DjYhew6xGgj7EVIXcPoGggiaZrJwpHQqw")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(convertObjectToJsonString(user))
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists());

    }



    private String convertObjectToJsonString(Object user) {
        try{
            return new ObjectMapper().writeValueAsString(user);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    // get all users:testing
    @Test
    public void getAllUsersTest() throws Exception {
        UserDto object1 = UserDto.builder().name("pranav").email("pranav@gmail.com").password("123456").about("testing").imageName("abc.png").build();
        UserDto object2 = UserDto.builder().name("pranav").email("pranav@gmail.com").password("123456").about("testing").imageName("abc.png").build();
        UserDto object3 = UserDto.builder().name("pranav").email("pranav@gmail.com").password("123456").about("testing").imageName("abc.png").build();
        UserDto object4 = UserDto.builder().name("pranav").email("pranav@gmail.com").password("123456").about("testing").imageName("abc.png").build();
        UserDto object5 = UserDto.builder().name("pranav").email("pranav@gmail.com").password("123456").about("testing").imageName("abc.png").build();


        PageableResponse<UserDto> pageableResponse = new PageableResponse<>();
        pageableResponse.setContent(Arrays.asList(
            object1,object2,object3,object4,object5
        ));
        pageableResponse.setLastPage(false);
        pageableResponse.setTotalElements(100);
        pageableResponse.setPageSize(10);
        pageableResponse.setPageNumber(100);
        Mockito.when(userService.getAllUser(Mockito.anyInt(),Mockito.anyInt(),Mockito.anyString(),Mockito.anyString())).thenReturn(pageableResponse);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(convertObjectToJsonString(user))
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists());


    }


}
