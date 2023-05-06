package com.example.hellospring;

import com.example.hellospring.repository.*;
import com.example.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em){
        this.em=em;
    }
    @Bean //스프링 빈을 등록하겠다는 의미
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
