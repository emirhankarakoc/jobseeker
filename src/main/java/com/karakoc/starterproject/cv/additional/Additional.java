package com.karakoc.starterproject.cv.additional;


import com.karakoc.starterproject.cv.additional.requests.CreateAdditionalRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
public class Additional {
    @Id
    private String id;
    private String cvId;
    private String field;


    public static Additional createSimpleAdditional(CreateAdditionalRequest r) {
        Additional additional = new Additional();
        additional.setId(UUID.randomUUID().toString());
        additional.setCvId(r.getCvId());
        additional.setField(r.getField());
        return additional;
    }

    public static AdditionalDTO additionalToDto(Additional a) {
        AdditionalDTO dto = new AdditionalDTO();
        dto.setId(a.getId());
        dto.setCvId(a.getCvId());
        dto.setField(a.getField());
        return dto;
    }

}
