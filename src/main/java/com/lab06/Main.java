package com.lab06;

import Utils.dao.StudentDAO;

public class Main {
    public static void main(String[] args)
    {
        StudentDAO studentDao = new StudentDAO();
        studentDao.removeStudent(1);
    }


}
