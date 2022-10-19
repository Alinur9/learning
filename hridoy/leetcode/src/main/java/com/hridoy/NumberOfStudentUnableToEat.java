package com.hridoy;

public class NumberOfStudentUnableToEat {
    public int countStudents(int[] students, int[] sandwiches) {

    int leftStudent = students.length;
    int len = students.length;
    for (int i=0;i<len;i++){
        if (students [i] != sandwiches[i]){
            int temp = students[i];
        for (int j =i;j<len;j++) {
            if (j+1 != len) {
                students[j] = students[j + 1];
            }
            if (len-1 == j){
                break;
            }
        }
            students[len-1] = temp;
        }
        if (students [i] == sandwiches[i]){
            leftStudent--;
        }
    }
    return leftStudent;
    }

    public static void main(String[] args) {
    int[] students = {1,1,0,0};
    int[] sandwiches = {0,1,0,1};

    NumberOfStudentUnableToEat obj = new NumberOfStudentUnableToEat();
        System.out.println(obj.countStudents(students,sandwiches));

    }
}
