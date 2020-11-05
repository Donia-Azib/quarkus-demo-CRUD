package service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pojo.Member;
import service.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    MemberDTO addMember(MemberDTO member);

    MemberDTO FindMemberById(Long _id);

    Page<MemberDTO> findAll(Pageable pageable);

    List<MemberDTO> findAllMember();

    MemberDTO UpdateUser(MemberDTO member);

    void DeleteUser(Long id);


















}
