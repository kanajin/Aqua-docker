package icu.samnyan.aqua.sega.ongeki.dao.userdata;

import icu.samnyan.aqua.sega.ongeki.model.userdata.UserData;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("OngekiUserItemRepository")
public interface UserItemRepository extends JpaRepository<UserItem, Long> {

    List<UserItem> findByUser_Card_ExtId(long userId);

    Page<UserItem> findByUser_Card_ExtId(long userId, Pageable page);

    Optional<UserItem> findByUserAndItemKindAndItemId(UserData userData, int itemKind, int itemId);

    Page<UserItem> findByUser_Card_ExtIdAndItemKind(long userId, int kind, Pageable page);

    @Transactional
    void deleteByUser(UserData user);
}
