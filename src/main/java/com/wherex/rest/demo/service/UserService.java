package com.wherex.rest.demo.service;

import com.wherex.rest.demo.model.RequestCounter;
import com.wherex.rest.demo.model.User;
import com.wherex.rest.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    public UserService(UserRepository userRepository,
                       RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }
    
    public User getUser(String login){
        User user = getUserFromApi(login);
        user.setCalculations(6 / user.getFollowers() * (2 + user.getPublicRepos()));
        incrementUserCounter(login);
        return user;
        
    }

    private void incrementUserCounter(String login) {
        boolean exist = userRepository.existsByLogin(login);
        if(exist) {
            userRepository.updateCounterByLogin(login);
        }else {
            userRepository.save(new RequestCounter(login));
        }
    }
    
    private User getUserFromApi(String login){
        String url = String.format("%s/%2s", baseUrl, login);
        return restTemplate.getForObject(url, User.class);
    }
}
