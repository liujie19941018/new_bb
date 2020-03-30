package com.example.demo.controllor;
import com.example.demo.dao.UserDao;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Test {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Map say(@RequestParam(value = "page", required=false,defaultValue="")Integer page,
                   @RequestParam(value = "limit", required=false,defaultValue="") Integer limit,
                   @RequestParam(value = "id", required = false,defaultValue = "") Integer id){
        HashMap map=new HashMap();
        List<UserModel> list =userDao.loadUser(page,limit,id);
        Integer count = userDao.getCount(id);
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        return map;
    }

}
