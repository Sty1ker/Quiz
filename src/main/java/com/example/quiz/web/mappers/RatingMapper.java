package com.example.quiz.web.mappers;

import com.example.quiz.web.dto.Rating.RaitingDto;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface RatingMapper {
    RaitingDto toDTO(RatingMapper rating);

    RatingMapper toEntity(RaitingDto dto);
}
