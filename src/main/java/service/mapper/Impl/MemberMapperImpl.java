package service.mapper.Impl;

import pojo.Member;
import service.dto.MemberDTO;
import service.mapper.MemberMapper;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class MemberMapperImpl implements MemberMapper {
    @Override
    public Member toEntity(MemberDTO dto) {
        if(dto == null)
            return null;
        else
            return new Member(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getEmail(), dto.getPhone());
    }

    @Override
    public MemberDTO toDto(Member entity) {
        MemberDTO dto = new MemberDTO();
        if(entity == null)
            return null;
        dto.setId(entity.getId());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    @Override
    public List<Member> toEntity(List<MemberDTO> dtoList) {
        if(dtoList == null)
            return null;
        List<Member> members = new ArrayList<Member>(dtoList.size());
        for(MemberDTO m : dtoList)
        {
            members.add(toEntity(m));
        }
        return members;
    }

    @Override
    public List<MemberDTO> toDto(List<Member> entityList) {
        if(entityList == null)
            return null;
        List<MemberDTO> members = new ArrayList<MemberDTO>(entityList.size());
        for(Member m : entityList)
        {
            members.add(toDto(m));
        }
        return members;
    }
}
