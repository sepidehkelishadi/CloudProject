package com.anbuzhobbiez.spannerdemo.users.repository;

import com.anbuzhobbiez.spannerdemo.users.domain.Users;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends SpannerRepository<Users, String> {
    @Query("SELECT * from users u where u.email = @email")
    Users findByEmail(@Param("email") String email);

}
