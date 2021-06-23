package org.compain.library.exposition;


import org.compain.library.security.AuthenticationService;
import org.compain.library.service.DTO.AuthenticationDTO;
import org.compain.library.service.DTO.UserDTO;
import org.compain.library.service.UserMapper;
import org.compain.library.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connexion")
public class UserControler {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    public UserControler(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> signIn(@RequestBody AuthenticationDTO dto){
        String token = authenticationService.signIn(dto.getUsername(), dto.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody UserDTO userDto){
       userService.save(UserMapper.toEntity(userDto));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody String token){

    }


}
