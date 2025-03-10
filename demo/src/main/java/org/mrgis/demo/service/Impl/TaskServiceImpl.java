package org.mrgis.demo.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.mrgis.demo.mapper.TaskMapper;
import org.mrgis.demo.pojo.PageBean;
import org.mrgis.demo.pojo.Task;
import org.mrgis.demo.service.TaskService;
import org.mrgis.demo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public void add(Task task) {
        //补充属性值
        task.setCreateTime(LocalDateTime.now());
        task.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        task.setCreateUser(userid);
        taskMapper.add(task);
    }

    @Override
    public PageBean<Task> list(Integer pageNum, Integer pageSize) {
        //创建pagebean对象
        PageBean<Task> pb = new PageBean<>();

        //开启分页查询pagehelper
        PageHelper.startPage(pageNum,pageSize);

        //调用mapper
        List<Task> as=taskMapper.list();
        Page<Task> p=(Page<Task>) as;

        //将数据填充到pageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());

        return pb;
    }

    @Override
    public void update(Task task) {
        task.setUpdateTime(LocalDateTime.now());
        taskMapper.update(task);
    }

    @Override
    public void delete(Integer id) {
        taskMapper.delete(id);
    }
}
