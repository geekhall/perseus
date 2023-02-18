package cn.geekhall.hera.server.service.impl;

import cn.geekhall.hera.server.entity.Teacher;
import cn.geekhall.hera.server.mapper.TeacherMapper;
import cn.geekhall.hera.server.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author yiny
 * @since 2022-03-26
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
