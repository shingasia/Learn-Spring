package com.bitacademy.services.member;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bitacademy.config.RepositoriesConfig;
import com.bitacademy.entities.MemberVO;
import com.bitacademy.exceptions.PasswordAndPasswordConfirmDifferentException;
import com.bitacademy.exceptions.PhoneRegexNotMatchException;
import com.bitacademy.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service("memberRegisterService")
@Import(RepositoriesConfig.class)
public class MemberRegisterService {
    
    @Autowired
    private MemberRepository memberRepository;

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    
    public MemberVO registerMember(MemberRegisterRequest memberRequest){

        if(!memberRequest.getPassword().equals(memberRequest.getConfirmPassword())){ //비밀번호, 비밀번호 확인이 다를 때
            throw new PasswordAndPasswordConfirmDifferentException();
        }
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3,4}-\\d{4}");
        Matcher matcher = pattern.matcher(memberRequest.getPhone());
        if(!matcher.matches()){ //핸드폰 번호가 정규표현식에 어긋날 때
            throw new PhoneRegexNotMatchException();
        }
        MemberVO newMember=new MemberVO();
        newMember.setId(memberRequest.getId());
        newMember.setPassword(memberRequest.getPassword());
        newMember.setName(memberRequest.getName());
        newMember.setPhone(memberRequest.getPhone());

        memberRepository.save(newMember);
        return newMember;
    }


}