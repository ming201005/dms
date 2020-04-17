package com.niudao.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.Course;
import com.niudao.app.entity.Product;
import com.niudao.app.service.CourseService;
import com.niudao.app.service.ProductService;
import com.niudao.app.vo.CourseVo;
import com.niudao.app.vo.WebCourseVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    CourseService courseService;

    @Resource
    private ProductService productService;

    @Test
    void contextLoads() {
        Product product = new Product();

        boolean rs = this.productService.save(product);

    }


    /**
     * 查询课程信息
     */
    @Test
    void test() {

        Course course = new Course();
//        course.setCourseTypeId("a2bf1fd80ce1bb32b1febe49e88af866");
//        course.setCourseCategoryId("520c3db3288266908aa6d21d3779ce8a");
//        course.setCourseName("5");
        IPage<CourseVo> iPage =  this.courseService.getCourseList(new Page<>(1,30),course);

        System.out.println(iPage.getTotal());
        System.out.println("iPage.getPages() = " + iPage.getPages());
        //System.out.println("iPage.getRecords() = " + iPage.getRecords());
        List<CourseVo> list = iPage.getRecords();
        list.forEach(item->{
            System.out.println("item = " + item);
        });
    }

    /**
     * 查询课程信息
     */
    @Test
    void test02() {

        Page<Course> page = new Page();
        page.setCurrent(1);
        page.setSize(5);
        String courseCategoryId = null;
        String courseTypeId = null;
        List<String> courseKnowledgeList = null;
        List<String> courseForPeopleList = null;
        String keyword = null;
        Integer orderType = null;
        IPage<WebCourseVo> iPage =  this.courseService.getCourse(page,courseCategoryId,courseTypeId,courseKnowledgeList,courseForPeopleList,keyword,orderType);

        System.out.println(iPage.getTotal());
        System.out.println("iPage.getPages() = " + iPage.getPages());
        //System.out.println("iPage.getRecords() = " + iPage.getRecords());
        List<WebCourseVo> list = iPage.getRecords();
        list.forEach(item->{
            System.out.println("item = " + item);
        });
    }

    @Test
    void getCourseById(){
        CourseVo courseVo = this.courseService.getCourseById("132b4c1597b05e2d214b0a17bdcf6aa0");
        System.out.println(courseVo);
    }

}
