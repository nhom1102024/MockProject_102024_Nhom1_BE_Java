package com.lease_master.service.role;


import com.lease_master.exceptions.RegistrationException;
import com.lease_master.model.Role;
import com.lease_master.repository.RoleRepository;
import com.lease_master.utils.ExceptionMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing roles.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final ExceptionMessageAccessor exceptionMessageAccessor;

    /**
     * Saves a new role or updates an existing one.
     *
     * @param role the role to save or update
     * @return the saved or updated role
     */
    public Role save(Role role) {
        log.info("Saving role: {}", role);

        if (role.getRoleId() == null) {
            role.setDeletedAt(null);

            if (roleRepository.existsByRoleName(role.getRoleName())) {
                log.warn("{} is already being used!", role.getRoleName());
                final String existsRoleName = exceptionMessageAccessor.getMessage(null, "ROLE_NAME_ALREADY_EXISTS");
                throw new RegistrationException(existsRoleName);
            }
        }

        return roleRepository.save(role);
    }


    /**
     * Finds a role by ID.
     *
     * @param id the ID of the role
     * @return an optional containing the role if found, otherwise empty
     */
    public Optional<Role> findById(Integer id) {
        log.info("Fetching role with id: {}", id);
        return roleRepository.findById(id);
    }

    /**
     * Retrieves all roles that are not softly deleted.
     *
     * @return a list of roles
     */
    public List<Role> findAll() {
        log.info("Fetching all roles");
        return roleRepository.findAll();
    }

    /**
     * Soft deletes a role by setting the deletedAt field to the current time.
     *
     * @param id the ID of the role to softly delete
     */
    @Transactional
    public void softDelete(Integer id) {
        log.info("Soft deleting role with id: {}", id);
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("role with id {} not found", id);
                    return new RuntimeException("role not found");
                });
        role.setDeletedAt(LocalDateTime.now());
        roleRepository.save(role);
        log.info("role with id {} soft deleted successfully", id);
    }

    /**
     * Checks if a role exists by ID.
     *
     * @param id the ID of the role
     * @return true if the role exists, false otherwise
     */
    public boolean existsById(Integer id) {
        log.info("Checking existence of role with id: {}", id);
        return roleRepository.existsById(id);
    }
}