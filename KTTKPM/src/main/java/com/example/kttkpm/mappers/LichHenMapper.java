package com.example.kttkpm.mappers;



import com.example.kttkpm.Model.LichHen;
import com.example.kttkpm.dto.LichHenDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LichHenMapper {

    private final ModelMapper modelMapper ;

    public LichHenMapper() {
        this.modelMapper = new ModelMapper() ;
    }

    public LichHenDTO convertToDTO(LichHen lichHen) {
        return modelMapper.map(lichHen, LichHenDTO.class);
    }

    public LichHen convertToEntity(LichHenDTO lichHenDTO) {
        return modelMapper.map(lichHenDTO, LichHen.class);
    }
}
