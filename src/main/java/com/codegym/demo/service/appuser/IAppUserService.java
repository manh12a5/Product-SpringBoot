package com.codegym.demo.service.appuser;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.service.IService;

public interface IAppUserService extends IService<AppUser> {

    AppUser findAppUserByName(String name);
    AppUser getCurrentUser();
}
