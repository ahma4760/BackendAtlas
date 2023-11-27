package com.example.backendatlas.service;

import com.example.backendatlas.entity.User;

import java.util.List;

public interface IUserService extends ICrudService<User,Long>{
    List<User> findByName(String name);
}
