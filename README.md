# Online high school management system

### Key words: high school management system, Java, Spring, MVC, relational database, Hibernate, MySQL, TomCat, JSP, HTML, CSS, Intellij Idea.
***
## Description:
The purpose of this engineering work was to develop a website for managing high school. The website has been implemented with the use of many libraries and tools that support the process of creating an application based on the model-view-controller (MVC) architecture. Programming took place in the Intellij Idea programming environment, using the object-oriented Java language. One of the most important libraries used in this project is the Spring library. To store and save data, a MySQL relational database has been created that contains information about all system users and the relationships that occur between them. The database was created using the Hibernate library, which allows it to be modified by Java code. All assumed tasks have been done and tested on the local server.
***
## Documentation of the capabilities of the implemented website
This chapter will be divided into three parts, which will present the functionality of the administrator, teacher and student.
* ### View of the website from the administrator's side
The figure shows the login page to which every user has access. By providing a username and password, the user can log in to the site.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/login.png)

After logging in to the administrator account, the user can see all students who are in school by clicking the "Students" tab, which is in the menu. It is also possible to search for a student by giving his surname or first name or class in which he is located.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/admin_pupils.png)

As you can see in this example, in the upper right corner of this site is the "Add student" button, which allows you to add a new student to the site. It is also possible to edit student data. This can be done by selecting one student from the table. The edit page is identical to the add students page, only it has filled fields
with the relevant data that can be changed.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/admin_editPupil.png)

As you can see, there is a "Delete Student" button on this page, which allows you to remove a student from the database.

The page from the "Teachers" menu item is identical to the "Students" page, except that
the table contains data about all school teachers, therefore this page is not presented.

The "Classes" page contains data about all school grades, and is presented in Figure.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/admin_classes.png)

As you can see, on this page you can immediately create a new class and add it to the database, it is also possible to delete the class.

On the "Subjects" page you can see all subjects that are taught at school. This page also has the option of adding and deleting data.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/admin_subjects.png)

In the 'Lessons' tab, you can add Lessons for the selected class. This works in such a way that the subject is selected and the teacher who will lead it for the selected class.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/admin_lessons.png)


As you can see, in the upper right corner you can choose the class for which they are displayed. You can add classes by selecting the subjects and teachers that are in the BD.

If the class has lessons, it is possible to create a timetable in the "Timetables" tab . Timetable settings are done by selecting one of the added classes to the appropriate place in the table (as exemplified in the figure below).

![Timetable Img](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/admin_schedule.png)

* ### Teacher's site view

After logging in to the website as a teacher, in the "Activities" tab, the user can choose the activity and date of the activity in which he wants to change or add the appropriate information. On this page, the teacher can enter grades and check student attendance. In the upper right corner, the user selects one of the possible classes, and below selects the date of the class from all possible dates, the list of which is created on the basis of the class schedule.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/teacher_lesson.png)

Figure below presents the "Marks" tab, which shows all student's marks obtained for the selected class.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/teacher_marks.png)

Figure below presents the 'Frequency' page with information on the frequency of students in selected classes.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/teacher_frequency.png)

This page shows the percentage of attendance, which is calculated based on the number of all classes of the selected subject that have taken place to this day.

On the "Exam" page, the teacher can add the subject and date of the exam, which will take place sometime in the future.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/teacher_test.png)

In the "Timetables" tab, the teacher can see his own timetable, which was configured on the administrator's page.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/teacher_schedule.png)

On the "My school" page, the user can see the main information about the school and see a list of students in the class in which he is the mentor.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/teacher_info.png)

On the "Teacher's Data" page, the user can see personal data and change them.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/teacher_data.png)

* ### Service view from the student's side

After logging into the website as a student, in the "Ratings" tab, the user can see all the grades he has obtained.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/pupil_marks.png)

In the 'Frequency' tab, the student can see information about their attendance at various classes.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/pupil_frequency.png)

In the 'Diary' tab, the student can see his / her schedule, grades and attendance that he / she obtained during the selected week.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/pupil_dayBook.png)

As you can see, the table displays the classes according to the schedule. If a student receives a grade, this grade is displayed in the appropriate place and is marked with a blue color. The red color is marked by the student's absence in one class or another.

In the "Homework" tab, the student can see all the homework entered by teachers for the selected week that he or she has to complete.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/pupil_homework.png)

Figure below shows the "Exam" page, where the user can see all the tests added by teachers for the next four weeks.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/pupil_test.png)

On the "School and teachers" page, the student can see the main information about the school, and information about all their subjects and teachers who teach them.

![](https://github.com/NikitaVovk/schoolDiploma/blob/master/Screenshots/pupil_info.png)

The 'Student Data' page is identical to the 'Teacher Data' page, so it is not shown.
