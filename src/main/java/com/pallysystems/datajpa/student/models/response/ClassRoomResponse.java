package com.pallysystems.datajpa.student.models.response;

import com.pallysystems.datajpa.student.models.Classroom;

public class ClassRoomResponse {

    private final Classroom classroom;

    public ClassRoomResponse(Classroom classroom) {
        this.classroom = classroom;
    }

    public Long getId() {
        return this.classroom.getId();
    }

    public String getName() {
        return this.classroom.getName();
    }
}
