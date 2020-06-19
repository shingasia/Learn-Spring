package com.bitacademy.services.member;

import java.util.NoSuchElementException;

import com.bitacademy.config.RepositoriesConfig;
import com.bitacademy.entities.MemberVO;
import com.bitacademy.exceptions.MemberNotFoundException;
import com.bitacademy.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("memberDeleteService")
@Import(RepositoriesConfig.class)
public class MemberDeleteService {
    
    @Autowired
    private MemberRepository memberRepository;

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // IllegalArgumentException, NoSuchElementException 둘 다 RuntimeException
    @Transactional
    public MemberVO deleteMember(String id, String password) {
        
        try{
            MemberVO obj = memberRepository.findById(id).get();
            memberRepository.delete(obj);
            return obj;
        }catch (IllegalArgumentException | NoSuchElementException e){
            throw new MemberNotFoundException();
        }
        
    }

}