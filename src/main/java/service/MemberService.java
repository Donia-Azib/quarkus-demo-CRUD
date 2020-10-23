package service;

import pojo.Member;

import java.util.List;

public interface MemberService {

    Member addMember(Member member);

    Member FindMemberById(Long _id);

    List<Member> findAll();

    Member UpdateUser(Member member);

    void DeleteUser(Long id);


















}
