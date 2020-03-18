package com.wq.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Role implements Serializable {
    private Integer id;

    private String roleName;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}