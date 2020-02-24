package de.changeperspective.enertrack.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.changeperspective.enertrack.persistence.dao.UserDao;
import de.changeperspective.enertrack.persistence.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    UserDao userDao;

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    private void registerObjectMapperModules() {
        objectMapper.findAndRegisterModules();
    }

    @RequestMapping("")
    public String userInit() {
        // save a few users
        User sancho = new User("Sancho", "r.brameier@gmail.com", "Di1gPfE.");
        User abraham = new User("abraham", "justdoit@gmail.com", "aaa");
        User zac = new User("Zac", "zac@mckracken.com", "eichhörnchen");

        userDao.save(sancho);
        userDao.save(abraham);
        userDao.save(zac);

        StringBuilder sb = new StringBuilder();
        // fetch all user
        sb.append("User found with findAll():");
        sb.append("</br>");
        for (User user : userDao.findAll()) {
            sb.append(user.toString());
            sb.append("</br>");
        }
        sb.append("</br>");

        // fetch an individual user by ID
        User user1 = userDao.findById(1L);
        sb.append("User found with findById(1L):");
        sb.append("</br>");
        sb.append(user1.toString());
        sb.append("</br>");

        // fetch watermeters greaterThan Himmel
        sb.append("User found with findByNickNameGreaterThanEqual('Himmel'):");
        sb.append("</br>");
        for (User user : userDao.findByNickNameGreaterThanEqualAllIgnoringCase("Himmel")) {
            boolean b = user.getNickName().compareTo("Himmel") >= 0;
            sb.append("Vergleich " + user.getNickName() + ": " + b);
            sb.append(user.toString());
            sb.append("</br>");
        }

        return "Userübersicht:</br>" + sb.toString();
    }

}



