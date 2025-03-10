package org.mrgis.demo.controller;

import org.mrgis.demo.pojo.PageBean;
import org.mrgis.demo.pojo.Result;
import org.mrgis.demo.pojo.Task;
import org.mrgis.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public Result add(@RequestBody @Validated Task task){
        taskService.add(task);
        return Result.success();
    }
    @GetMapping("/list")
    public Result<PageBean<Task>> list(
            Integer pageNum,
            Integer pageSize
    ){
        PageBean<Task> pb = taskService.list(pageNum,pageSize);
        return Result.success(pb);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated Task task){
        taskService.update(task);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer id){
        taskService.delete(id);
        return Result.success();
    }
}
