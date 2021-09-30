package com.work.inetum01.dto;

import com.work.inetum01.entities.AuditModel;
import lombok.Data;

@Data
public class CategoryDTO extends AuditModel {
    private long id ;
    private String name ;
}
