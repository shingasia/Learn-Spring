package com.bitacademy.services.member;

import java.util.NoSuchElementException;

import com.bitacademy.entities.MemberVO;
import com.bitacademy.exceptions.MemberAlreadyExistException;
import com.bitacademy.exceptions.MemberNotFoundException;
import com.bitacademy.exceptions.WrongPasswordException;
import com.bitacademy.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service("modifyPasswordService")
@Import(MemberRepository.class)
public class ModifyPasswordService {
    
    @Autowired
    private MemberRepository memberRepository;

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberVO modifyPassword(String id, String oldPassword, String newPassword){
        MemberVO member=null;
        try{
            member=memberRepository.findById(id).get(); //해당 아이디 검색
        }catch(NoSuchElementException e){
            throw new MemberNotFoundException();
        }
        
        if(!member.getPassword().equals(oldPassword)){ //기존의 비밀번호와 입력한 oldPassword와 일치하지 않으면
            throw new WrongPasswordException();
        }
        member.setPassword(newPassword);//비밀번호 변경
        memberRepository.save(member);
        return member;
    }

}