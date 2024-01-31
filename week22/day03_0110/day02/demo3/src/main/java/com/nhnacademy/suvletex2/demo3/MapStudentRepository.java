package com.nhnacademy.suvletex2.demo3;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapStudentRepository implements StudentRepository {
    private Map<String, Student> studentsMap = new ConcurrentHashMap<>();

    @Override
    public void save(Student student) {
        if (student == null || student.getId() == null) {
            throw new IllegalArgumentException("Student or Student ID cannot be null");
        }
        studentsMap.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        if (student == null || student.getId() == null) {
            throw new IllegalArgumentException("Student or Student ID cannot be null");
        }
        if (!studentsMap.containsKey(student.getId())) {
            throw new IllegalStateException("Cannot update non-existing student");
        }
        studentsMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(String id) {
        studentsMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        return studentsMap.get(id);
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(studentsMap.values());
    }

    @Override
    public boolean existById(String id) {
        return studentsMap.containsKey(id);
    }
}
