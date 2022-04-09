package icu.samnyan.aqua.sega.ongeki.dao.userdata;

import icu.samnyan.aqua.sega.ongeki.model.userdata.UserData;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("OngekiUserStoryRepository")
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    List<UserStory> findByUser_Card_ExtId(long userId);

    Optional<UserStory> findByUserAndStoryId(UserData userData, int storyId);

    @Transactional
    void deleteByUser(UserData user);
}
