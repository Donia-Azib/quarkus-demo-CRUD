package service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pojo.Member;
import repository.MemberRepository;
import service.MemberService;
import service.dto.MemberDTO;
import service.mapper.MemberMapper;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }
    @Override
    public MemberDTO addMember(MemberDTO member) {
        Member m ;

        m = memberMapper.toEntity(member);
        return memberMapper.toDto(memberRepository.save(m));

    }
    private boolean MemberExist(String email)
    {
        boolean test = false;
        List<MemberDTO> list = findAllMember();
        for(MemberDTO m :list)
        {
            if(m.getEmail().equals(email))
            {
                test=true;break;
            }
        }
        return test;
    }

    @Override
    public MemberDTO FindMemberById(Long _id) {
        return
                memberRepository.findById(_id).map(memberMapper::toDto)
                        .orElseThrow(() -> new NotFoundException("id Not Found"));
    }

    @Override
    public Page<MemberDTO> findAll(Pageable pageable) {

        if (pageable.isUnpaged()) {
            System.out.println("Unpaged");
            List<MemberDTO> result = findAllMember();
            return new PageImpl<>(result, Pageable.unpaged(), result.size());
        }
        else
        {
            System.out.println("paged");
            Page<MemberDTO> pagedResult = memberRepository.findAll(pageable).map(memberMapper::toDto);
            System.out.println("=>"+pagedResult.getContent().size());
            return new PageImpl<>(pagedResult.getContent(), pageable, pagedResult.getTotalElements());
        }
    }

    @Override
    public List<MemberDTO> findAllMember() {
        return memberMapper.toDto(memberRepository.findAll());
    }

    @Override
    public MemberDTO UpdateUser(MemberDTO member) {
        System.out.println("update");
        Member entity =  memberMapper.toEntity(member);
        return memberMapper.toDto(memberRepository.save(entity));
    }

    @Override
    public void DeleteUser(Long id) {
        System.out.println("DELETE");
        memberRepository.deleteById(id);
    }

}
