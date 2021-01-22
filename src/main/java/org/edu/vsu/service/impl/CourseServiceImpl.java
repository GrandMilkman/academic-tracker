package org.edu.vsu.service.impl;

import org.edu.vsu.dao.CourseRepository;
import org.edu.vsu.entity.Course;
import org.edu.vsu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course create(Course entity) {
        entity.setCourseGeneralHoursAmount(countCourseHours(entity));
        return this.courseRepository.saveAndFlush(entity);
    }

    @Override
    public Course get(Long id) {
        return this.courseRepository.getOne(id);
    }

    @Override
    public Course update(Course entity) {
        entity.setCourseGeneralHoursAmount(countCourseHours(entity));
        return this.courseRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAll() {
        return this.courseRepository.findAll();
    }

    private Long countCourseHours(Course course) {
        double lectureConsulting = course.getLectureHoursAmount() * 0.05;
        int consultingBeforeExam = course.getHasExam() ? 2 : 0;
        double examHours = course.getHasExam() ? 0.5 * course.getStudentsAmount() : 0;
        double creditHours = course.getHasCredit() ? 0.25 * course.getStudentsAmount() : 0;
        double testHours = 0.15 * course.getStudentsAmount() * course.getTestAmount();
        return (long) Math.ceil(course.getLabHoursAmount() + course.getLectureHoursAmount() +
                course.getPracticeHoursAmount() + lectureConsulting + consultingBeforeExam + examHours +
                creditHours + testHours);
    }
}
