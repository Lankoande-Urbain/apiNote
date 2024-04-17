package com.stagiaire.api_note.config;
import com.stagiaire.api_note.dto.noteDto;
import com.stagiaire.api_note.entity.E_Note;
import org.mapstruct.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)

public interface Mymapper {
    @Mappings({})
    noteDto maps(E_Note source);

    @InheritInverseConfiguration
    E_Note maps(noteDto dto);


}

