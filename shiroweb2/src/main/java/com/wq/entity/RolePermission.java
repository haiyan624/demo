package com.wq.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class RolePermission implements Serializable {
    private Integer id;

    private Integer permissionId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}