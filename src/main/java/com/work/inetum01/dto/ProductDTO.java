package com.work.inetum01.dto;

import com.work.inetum01.entities.AuditModel;
import com.work.inetum01.entities.Category;

public class ProductDTO extends AuditModel {
    private  long  id  ;
    private String name ;
    private int qt ;
    private Boolean disp ;
    private Category cat;

}
