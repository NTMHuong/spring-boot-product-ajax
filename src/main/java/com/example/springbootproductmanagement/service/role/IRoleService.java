package com.example.springbootproductmanagement.service.role;

import com.example.springbootproductmanagement.model.Role;
import com.example.springbootproductmanagement.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
