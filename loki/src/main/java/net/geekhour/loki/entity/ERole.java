package net.geekhour.loki.entity;

/**
 * ERole
 *
 * @author Jasper Yang
 * @create 2024/11/03 23:50
 */
public enum ERole {
    ROLE_ADMIN(1L),
    ROLE_MANAGER(2L),
    ROLE_MODERATOR(3L),
    ROLE_USER(4L),
    ROLE_DEV(5L),
    ROLE_TEST(6L);

    private final Long value;

    private ERole(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
