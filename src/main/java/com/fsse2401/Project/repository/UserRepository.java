package com.fsse2401.Project.repository;

import com.fsse2401.Project.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <UserEntity,Integer> {
    Optional<UserEntity> findByFirebaseUid (String firebaseUid);
}
