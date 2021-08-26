const courseList = document.querySelector("body > div.courselist")
courseList.addEventListener('click', e => {
  const selection = e.target.closest('.selection')
  const child = e.target
  if ( selection.className == 'selection'){
    window.location.href = `http://localhost:8080?lessonID=${selection.id}`
  }
  if (child.className == ''){

  }
})

