package com.techeer.svproject.domain.user;

import com.techeer.svproject.domain.user.dto.UserSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.techeer.svproject.global.utils.Constants.API_PREFIX;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping(API_PREFIX+"/users")
    public UUID save(@RequestBody UserSaveDto requestDTO) {return userService.save(requestDTO);}
}