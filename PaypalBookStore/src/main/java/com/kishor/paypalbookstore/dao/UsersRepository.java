package com.kishor.paypalbookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kishor.paypalbookstore.entity.Users;

//@Repository
//public interface UsersRepository extends JpaRepository<Users, Integer> {

@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users, Integer> {
	
	@Query("Select u from Users u where u.username=:username")
	public Users getUserByUsername(@Param("username") String username);
//	@Query(value="SELECT * from users where username=?1",nativeQuery=true)
//	public Users getUserByUsername(@Param("username") String username);

}
