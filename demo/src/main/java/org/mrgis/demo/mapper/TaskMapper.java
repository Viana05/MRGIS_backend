package org.mrgis.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.mrgis.demo.pojo.Task;

import java.util.List;

@Mapper
public interface TaskMapper {
    //新增
    @Insert("insert into task(task_name,task_content,task_cover,task_location,create_user," +
            "create_time,update_time) values (#{taskName},#{taskContent},#{taskCover}," +
            "#{taskLocation},#{createUser},now(),now())")
    void add(Task task);

    //条件查询列表
    List<Task> list();

    //更新任务
    @Update("update task set task_name=#{taskName},task_content=#{taskContent},task_cover=#{taskCover}," +
            "task_location=#{taskLocation},update_time=now() where id=#{id}")
    void update(Task task);

    //删除任务
    @Delete("delete from task where id=#{id}")
    void delete(Integer id);
}
