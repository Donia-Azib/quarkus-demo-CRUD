package service.mapper;

import org.mapstruct.Mapper;
import pojo.Member;
import service.dto.MemberDTO;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {})
public interface MemberMapper extends EntityMapper<MemberDTO, Member> {
    @Override
    Member toEntity(MemberDTO dto);

    @Override
    MemberDTO toDto(Member entity);

    @Override
    List<Member> toEntity(List<MemberDTO> dtoList);

    @Override
    List<MemberDTO> toDto(List<Member> entityList);
}
