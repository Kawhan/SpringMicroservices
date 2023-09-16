package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.mappers;


import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto.JobRequestDTO;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.entity.Job;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    @Autowired
    ModelMapper modelMapper;

    public Job updateJobFromDto(JobRequestDTO jobRequestDTO, Job jobToUpdate) {
        modelMapper.map(jobRequestDTO, jobToUpdate);
        return jobToUpdate;
    }
}
