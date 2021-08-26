const courseList = document.querySelector("body > div.courselist")
courseList.addEventListener('click', e => {
  const selection = e.target.closest('.selection')
  const child = e.target
  if (child.className == 'remove-btn'){
    console.log('remove btn')
    const question = e.target.closest('.selection')
    const id = question.id
    const form = question.querySelector('.removeCourse')
    form.submit()
  }
  else if (selection.className == 'selection'){
    window.location.href = `http://localhost:8080?lessonID=${selection.id}`
  }
})

