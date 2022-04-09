package icu.samnyan.aqua.sega.chunithm.dao.userdata;

import icu.samnyan.aqua.sega.chunithm.model.userdata.UserData;
import icu.samnyan.aqua.sega.chunithm.model.userdata.UserDataEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository
public interface UserDataExRepository extends JpaRepository<UserDataEx, Long> {

    Optional<UserDataEx> findByUser(UserData user);

    Optional<UserDataEx> findByUser_Card_ExtId(Long extId);
}
