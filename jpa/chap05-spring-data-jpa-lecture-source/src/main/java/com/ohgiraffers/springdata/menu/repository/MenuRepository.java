package com.ohgiraffers.springdata.menu.repository;

import com.ohgiraffers.springdata.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findByMenuPriceGreaterThan(int menuPrice);
}
