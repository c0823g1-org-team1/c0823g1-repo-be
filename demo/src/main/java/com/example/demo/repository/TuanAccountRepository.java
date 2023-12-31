package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Query(nativeQuery = true,value = "select ac.* from account ac where name_account = :name_account limit 1")
    Account checkUserAccount(@Param("name_account") String name_account);

//    Account findAccountByNameAccount(String name_account);
    @Query(nativeQuery = true,value = "select ac.* from account ac where phone_client = :phone_client limit 1")
    Account checkPhoneAccount(@Param("phone_client") String phone_client);
    @Query(nativeQuery = true,value = "select ac.* from account ac where email_client = :email_client limit 1")
    Account checkEmailAccount(@Param("email_client") String email_client);
    @Query(nativeQuery = true,value = "select ac.* from account ac where identify_client = :identify_client limit 1")
    Account checkIndentifyAccount(@Param("identify_client") String identify_client);
    @Query(nativeQuery = true,value = "select ac.* from account ac join role r on ac.role_id = r.id where ac.name_account like concat('%',:account_name,'%') and (ac.role_id = :role_id or :role_id = -1)",
            countQuery = "select count(*) from (select ac.* from account ac join role r on ac.role_id = r.id where ac.name_account like concat('%',:account_name,'%') and (ac.role_id = :role_id or :role_id = -1)) temp")
    Page<Account> getAllAccountPage(Pageable pageable,@Param("account_name")String account_name,@Param("role_id") Integer role_id);

}
