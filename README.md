# Mock
Mock
## Rest Api
#### GET METHOD
```
http://localhost:8080/courses
```
Get all courses
```
http://localhost:8080/course/{course-id}
```
Get all quizes which belong to course having `{course-id}`
#### POST METHOD
```
http://localhost:8080/courses/add
```
Adding a new course
```
http://localhost:8080/quiz/add
```
Adding a new quiz

#### REQUEST HEADER (if needed)
Auth
{
  "username" : "admin",
  "password" : 1
}
#### REQUEST BODY
Course
{
  "id": `course-id`,
  "name": `course-name`
}
> Quiz
{ 
    "id" : `quiz-id`
    "idCourse": `course-id`,
    "question": `quiz-question`,
    "ans1" : `quiz-choice-1`,
    "ans2" : `quiz-choice-2`,
    "ans3" : `quiz-choice-3`,
    "ans4" : `quiz-choice-4`,
    "ans" : `quiz-answer (must be between 1 and 4)` 
}
## OTHER
To use Sql Server **MUST** use Sql Server Authentication with:
Login: mock
Password: pass