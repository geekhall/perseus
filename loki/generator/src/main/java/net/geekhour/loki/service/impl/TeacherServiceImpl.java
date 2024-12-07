package net.geekhour.loki.service.impl;

import net.geekhour.loki.entity.Teacher;
import net.geekhour.loki.mapper.TeacherMapper;
import net.geekhour.loki.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Jasper Yang
 * @since 2024-11-03
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
