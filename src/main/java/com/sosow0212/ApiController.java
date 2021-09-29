package com.sosow0212;

import model.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    private Map<String, UserProfile> userMap;
    @PostConstruct
    public void init() {
        userMap = new HashMap<String,UserProfile>();
        userMap.put("1", new UserProfile("1", "홍길동", "111", "영통"));
        userMap.put("2", new UserProfile("2", "이재윤", "222", "광교"));
        userMap.put("3", new UserProfile("3", "노윤재", "333", "홍대"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return userMap.get(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return new ArrayList<UserProfile>(userMap.values());
    }

    @PutMapping("/user/{id}") // Postman Put 방식으로 추가 가능
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        userMap.put(id, userProfile);
    }

    @PostMapping("/user/{id}") // post방식으로 수정
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        UserProfile userProfile = userMap.get(id); // id를 찾는다.
        userProfile.setName(name); // 이름 바꾸기
        userProfile.setPhone(phone);
        userProfile.setAddress(address);
    }

    @DeleteMapping("/user/{id}") // delete 방식으로 삭제
    public void deleteUserProfile(@PathVariable("id") String id) {
        userMap.remove(id);
    }
/////////////////////////////////////////////////////////////////////////////
    // 아래부터 간단한 방식

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK) // 정상적으로 받으면 OK
    public String getApiTest() {

        return "{\"result\":\"ok\"}";
    }
    // http://localhost:8080/api/test


    @RequestMapping(value = "/api/test2", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK) // 정상적으로 받으면 OK
    public String getApiTest2() {

        return "{\"result\":\"ok2\"}";
    }
    // http://localhost:8080/api/test2
    //dd
}
