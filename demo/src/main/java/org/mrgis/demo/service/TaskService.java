package org.mrgis.demo.service;

import org.mrgis.demo.pojo.PageBean;
import org.mrgis.demo.pojo.Task;

public interface TaskService {
    //新增任务
    void add(Task task);

    //条件分页列表查询
    PageBean<Task> list(Integer pageNum, Integer pageSize);

    //更行任务
    void update(Task task);

    //删除任务
    void delete(Integer id);
}
