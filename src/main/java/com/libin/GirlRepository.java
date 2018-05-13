package com.libin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer>{
    //通过年龄查询(扩展了一种查询方式)
    public List<Girl> findByAge(Integer age);
}
