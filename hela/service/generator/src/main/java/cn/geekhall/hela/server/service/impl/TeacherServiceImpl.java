package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Teacher;
import cn.geekhall.hela.server.mapper.TeacherMapper;
import cn.geekhall.hela.server.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
