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
>{
>  "username" : "admin", <br>
>  "password" : 1 <br>
>}
#### REQUEST BODY
Course
>{ <br>
>  "id": `course-id`, <br>
>  "name": `course-name` <br>
>}
Quiz
>{ <br>
>    "id" : `quiz-id`, <br>
>    "idCourse": `course-id`, <br>
>    "question": `quiz-question`, <br>
>    "ans1" : `quiz-choice-1`, <br>
>    "ans2" : `quiz-choice-2`, <br>
>    "ans3" : `quiz-choice-3`, <br>
>    "ans4" : `quiz-choice-4`, <br>
>    "ans" : `quiz-answer (must be between 1 and 4)` <br>
>}
## OTHER
To use Sql Server **MUST** use Sql Server Authentication with:
<br>
Login: `mock`
<br>
Password: `pass`