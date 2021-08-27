# Mock
A product for creating, doing quizzes in each lessons.
## Rest Api
#### GET METHOD
Get all courses
```
http://localhost:8080/courses
```
Get all quizes which belong to course having `{course-id}`
```
http://localhost:8080/courses/{course-id}
```
#### POST, PUT, DELETE METHOD
POST, PUT request, if success, will respond the requested **Object**, otherwise responding **null**
<br>
DELETE request doesn't respond anything.
<br>
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
>&nbsp;&nbsp;"username" : "admin", <br>
>&nbsp;&nbsp;"password" : 1 <br>
>}
#### REQUEST BODY
###### Course
>{ <br>
>&nbsp;&nbsp;"id": `course-id`, <br>
>&nbsp;&nbsp;"name": `course-name` <br>
>} <br>
###### Quiz
>{ <br>
>&nbsp;&nbsp;"id" : `quiz-id`, <br>
>&nbsp;&nbsp;"idCourse": `course-id`, <br>
>&nbsp;&nbsp;"question": `quiz-question`, <br>
>&nbsp;&nbsp;"ans1" : `quiz-choice-1`, <br>
>&nbsp;&nbsp;"ans2" : `quiz-choice-2`, <br>
>&nbsp;&nbsp;"ans3" : `quiz-choice-3`, <br>
>&nbsp;&nbsp;"ans4" : `quiz-choice-4`, <br>
>&nbsp;&nbsp;"ans" : `quiz-answer (must be between 1 and 4)` <br>
>}
#### REQUEST NOTE
POST request requires all properties except **ID**.
<br>
PUT request requires all properties.
<br>
DELETE request only requires **ID**.
## OTHER
To use Sql Server **MUST** use Sql Server Authentication with:
<br>
>Login: `mock`
>Password: `pass`
###### GUIDE CREATE SQL SERVER LOGIN
> https://kb.supremainc.com/knowledge/doku.php?id=en:1xfaq_how_to_create_a_sql_server_authentication_login_id
