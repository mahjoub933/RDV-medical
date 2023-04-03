package tn.mahjoub.rdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.mahjoub.rdv.model.LoginBody;
import tn.mahjoub.rdv.model.LoginResponse;
import tn.mahjoub.rdv.service.impl.UsersService;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthContoller {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginBody loginBody) {
        return new ResponseEntity<>(usersService.login(loginBody), HttpStatus.OK);
    }

}
