package cn.geekhall.hela.server.entity;

/**
 * ERole
 *
 * @author yiny
 * @date 2023/2/19 18:49
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
