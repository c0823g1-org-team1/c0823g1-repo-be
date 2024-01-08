package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TuanAccountRepository extends JpaRepository<Account, Integer> {
//    @Query(nativeQuery = true,value = "select * from detail_account where phone = :phone")
//    DetailAccount checkPhone(@Param("phone") String phone);
//    @Query(nativeQuery = true,value = "select * from detail_account where identify = :identify")
//    DetailAccount checkIdentify(@Param("identify") int identify);
//    @Query(nativeQuery = true,value = "select * from detail_account where email = :email")
//    DetailAccount checkEmail(@Param("email") String email);
//    @Query(nativeQuery = true,value = "select * from account where name_account = :name_account")
//    Account checkUserAccount(@Param("name_account") String name_account);
}
