package com.agendadortarefas.bussines.mapper;

import com.agendadortarefas.bussines.dto.TarefasDTO;
import com.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface TarefasConverter {

    TarefasEntity paraTarefasEntity(TarefasDTO dto);

    TarefasDTO paraTarefasDto(TarefasEntity entity);
}
