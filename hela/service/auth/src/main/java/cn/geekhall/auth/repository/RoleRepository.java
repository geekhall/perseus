package cn.geekhall.auth.repository;

import cn.geekhall.auth.models.ERole;
import cn.geekhall.auth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * RoleRepository
 *
 * @author yiny
 * @date 2023/2/12 16:44
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
