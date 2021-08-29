const courseList = document.querySelector("body > div.courselist")
courseList.addEventListener('click', e => {
  const selection = e.target.closest('.selection')
  const child = e.target
  if (child.className == 'remove-btn'){
    const input = selection.querySelector('.remove-input')
    console.log(input)
    input.click()
  }
  else if (child.className == 'update-btn'){
    const input = selection.querySelector('.update-input')
    console.log(input)
    input.click()
  }
  else if (selection.className == 'selection'){
    const name = selection.querySelector('h2').textContent
    const id = selection.getAttribute('id')
    window.location.href = `http://localhost:8080?lessonID=${id}&lessonName=${name}`
  }
})

