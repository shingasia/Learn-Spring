package com.bitacademy.services.member;

import java.util.NoSuchElementException;

import com.bitacademy.config.RepositoriesConfig;
import com.bitacademy.entities.MemberVO;
import com.bitacademy.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service("memberSearchService")
@Import(RepositoriesConfig.class)
public class MemberSearchService {
    
    @Autowired
    private MemberRepository memberRepository;

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberVO searchMember(String id) throws NoSuchElementException {
        MemberVO obj=memberRepository.findById(id).get();
        return obj;
    }

    

}