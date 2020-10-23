package service.Impl;

import pojo.Member;
import repository.MemberRepository;
import service.MemberService;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public Member addMember(Member member) {
        Member member1 = new Member();
        member1 = memberRepository.save(member);
        return member1;
    }

    @Override
    public Member FindMemberById(Long _id) {
        Member member=null;
        List<Member> list = memberRepository.findAll();
        System.out.println("REST size "+list.size());
        for(Member m : list)
        {
            System.out.println("REST _id "+m.getId());
            if(m.getId().equals(_id))
            {
                member=m;
                break;
            }
        }
        System.out.println("REST member "+ (member.getId() != null ? true:false));
        return member;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member UpdateUser(Member member) {
        System.out.println("update");
        return memberRepository.save(member);
    }

    @Override
    public void DeleteUser(Long id) {
        System.out.println("DELETE");
        memberRepository.deleteById(id);
    }

}
