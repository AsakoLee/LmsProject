package com.project.lms.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.lms.service.MemberService;
import com.project.lms.vo.MapVO;
import com.project.lms.vo.member.MemberJoinVO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService mService;

    @PutMapping("/join/{type}")
    public ResponseEntity<MapVO> joinMember(@PathVariable String type, @RequestBody @Valid MemberJoinVO data, BindingResult bindingResult){

        return new ResponseEntity<>(mService.joinMember(data, type, bindingResult), HttpStatus.OK);
    }


}
