package de.changeperspective.enertrack.persistence.dao;

import de.changeperspective.enertrack.persistence.dto.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Interface for UserRepository CRUD.
 * <p>
 * enertrack
 * <p>
 * Author Ralf Brameier
 * on GitHub Sanchoxo
 * visit project https://github.com/Sanchoxo/enertrack
 * <p>
 * Date 15. Februar 2020
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE UPPER(u.nickName) >= UPPER(:nickName)")
    List<User> findByNickNameGreaterThanEqualAllIgnoringCase(@Param("nickName") String nickname);

    User findById(long id);
}
