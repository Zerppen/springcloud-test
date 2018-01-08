package com.gmou.api.controller;

import com.alibaba.fastjson.JSONObject;
//import com.gmou.api.sdkintegration.End2endAndBackAgainIT;
//import com.gmou.api.sdkintegration.End2endIT;
import com.gmou.api.src.test.java.org.hyperledger.fabric.sdkintegration.End2endIT;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;



import static java.nio.charset.StandardCharsets.UTF_8;


/**
 * Created by admin on 2017/5/20.
 */
@RestController
@RequestMapping("")
public class HelloController {






    @RequestMapping("testFabric/checkConfig")
    public Object testFabric() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, MalformedURLException{

        End2endIT end2endIT = new End2endIT();
        return end2endIT.checkConfig();
//        end2endIT.setup();

    }

    @RequestMapping("testFabric/e2e")
    public Object testFabricE2e() throws Exception{

        End2endIT end2endIT = new End2endIT();
        end2endIT.setup();
        return null;
//        end2endIT.setup();

    }




    @RequestMapping("login")
    public Object hello(@RequestBody JSONObject msg) {

       String name =  msg.getString("tel");
       String pw = msg.getString("passwd");
       String ret = null;
       Map map = new HashMap();
       Map ms = new HashMap();
       Map data = new HashMap();
       data.put("access_token", UUID.randomUUID().toString());
       if(name.equals("13111111111")){
           if(pw.equals("00000000")){

               map.put("code","0");
               map.put("data",data);

           }else{
               ret = "Failed login! passwd error";
               map.put("code","3000");
               map.put("msg",ret);

           }
       }else{
           ret = "Failed login! login name error";
           //ms.put("message",ret);
           map.put("code","3000");
           map.put("msg",ret);
       }


        return map;
    }

}
