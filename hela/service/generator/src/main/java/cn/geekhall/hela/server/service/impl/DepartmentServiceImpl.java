package cn.geekhall.hela.server.service.impl;

import cn.geekhall.hela.server.entity.Department;
import cn.geekhall.hela.server.mapper.DepartmentMapper;
import cn.geekhall.hela.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author yiny
 * @since 2023-02-06
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
