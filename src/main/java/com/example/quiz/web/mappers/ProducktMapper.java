package com.example.quiz.web.mappers;

import com.example.quiz.domain.Produckt.Produckt;
import com.example.quiz.web.dto.Produckt.ProducktDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProducktMapper {

    ProducktDto toDTO(Produckt produckt);

    Produckt toEntity(ProducktDto producktDTO);
}
