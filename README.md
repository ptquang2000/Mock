# Mock
Mock
## Rest Api
#### GET METHOD
Get all courses
```
http://localhost:8080/courses
```
Get all quizes which belong to course having `{course-id}`
```
http://localhost:8080/course/{course-id}
```
#### POST, PUT, DELETE METHOD
For course table:
```
http://localhost:8080/courses
```
For quiz table:
```
http://localhost:8080/quiz
```

#### REQUEST HEADER (if needed)
###### Auth
>{ <br>
>  "username" : "admin", <br>
>  "password" : 1 <br>
>}
#### REQUEST BODY
###### Course
>{ <br>
>  "id": `course-id`, <br>
>  "name": `course-name` <br>
>} <br>
###### Quiz
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
>Login: `mock`
>Password: `pass`