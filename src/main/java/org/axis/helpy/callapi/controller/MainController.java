package org.axis.helpy.callapi.controller;

import org.axis.helpy.callapi.entity.CallDetail;
import org.axis.helpy.callapi.entity.KnowledgeBase;
import org.axis.helpy.callapi.jwt.JwtProvider;
import org.axis.helpy.callapi.repository.CallDetailRepository;
import org.axis.helpy.callapi.repository.KnowledgeBaseRepository;
import org.axis.helpy.callapi.repository.UserRepository;
import org.axis.helpy.callapi.request.AuthReq;
import org.axis.helpy.callapi.response.JwtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    KnowledgeBaseRepository knowledgeBaseRepository;
    @Autowired
    CallDetailRepository callDetailRepository;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @PostMapping("/api/v1/token")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthReq loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
            )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/api/v1/knowledge/find")
    public ResponseEntity<?> knowledge(@RequestBody KnowledgeBase base) {

        if(base.checkNull()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        try{
            Example<KnowledgeBase> exam = Example.of(base);
            return ResponseEntity.ok(knowledgeBaseRepository.findAll(exam));
        }catch (Exception e){
            logger.error("Internal Server Error. Message - {}", e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/api/v1/callhistory/find")
    public ResponseEntity<?> mostCallHistory(@RequestBody CallDetail mdl) {

        if(mdl.checkNull()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        try{
            Example<CallDetail> exam = Example.of(mdl);
            return ResponseEntity.ok(callDetailRepository.findAll(exam));
        }catch (Exception e){
            logger.error("Internal Server Error. Message - {}", e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
