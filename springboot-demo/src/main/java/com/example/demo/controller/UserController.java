package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 控制层调用业务层
 */
//@RestController     //Spring MVC注解，返回json数据，使用 thymeleaf 模板引擎必须使用 @Controller
@Controller
public class UserController {

    //注入业务层
    @Autowired
    private UserService userService;

    //    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @GetMapping("user/{id}")    // 如果是get方法，可直接使用@GetMapping注解
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }


    @RequestMapping("/jsplist")
    public ModelAndView redirectMAV(String name) throws Exception {

        //后台代码List集合
        List<String> list = new ArrayList<>();
        list.add("I");
        list.add("L");
        list.add("O");
        list.add("V");
        list.add("E");

        ModelAndView mv = new ModelAndView();

//        mv.addObject("name", name);

        mv.addObject("list", list);

        //使用重定向，此时springmvc.xml配置文件中的视图解析器将会失效
        mv.setViewName("forward:/jsp/listjsp.jsp");
        return mv;
    }

    @RequestMapping("/hello")
    public String listUser(String model) {
//        List<> userList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            userList.add(new UserDto(UUID.randomUUID().toString().replace("-", ""), "张三" + i, 1, "中国北京"));
//        }
//        model.addAttribute("users", userList);
        return "html/listhtml.html";
    }

    @RequestMapping("/list")
    public String listUser(Model model) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User(i, "张三" + i, 25, "中国北京"));
        }
        model.addAttribute("users", userList);
        return "user/list";
    }


    @RequestMapping(value = "importxsl", method = RequestMethod.POST)
    @ResponseBody
    public Object importdata(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();//原文件名字

        System.out.println("filename:" + filename);

        boolean notNull = false;
        InputStream is = file.getInputStream();
        Workbook wb;
        boolean isExcel2003 = true;
        if (filename.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {

            int rows = sheet.getPhysicalNumberOfRows();// 获取表格的行数

            System.out.println("rows:" + rows);
            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                int columns = sheet.getRow(r).getLastCellNum();
                if (row == null) {
                    continue;
                }

                for (int i = 0; i < columns; i++) {

                    Cell cell = row.getCell(i);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String data = cell.getStringCellValue();
                    System.out.println("data:" + data);
                }


//            String name = row.getCell(0).getStringCellValue();


//            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//            String phone = row.getCell(1).getStringCellValue();
//
//            String add = row.getCell(2).getStringCellValue();
//
//            Date date;
//
//            date = row.getCell(3).getDateCellValue();
//
//
//            String des = row.getCell(4).getStringCellValue();

            }
        }
        return true;
    }
}

