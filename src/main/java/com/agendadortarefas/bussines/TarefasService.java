package com.agendadortarefas.bussines;

import com.agendadortarefas.bussines.dto.TarefasDTO;
import com.agendadortarefas.bussines.mapper.TarefasConverter;
import com.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefasEntity(dto);

        return  tarefaConverter.paraTarefasDto(tarefasRepository.save(entity));
    }

}
