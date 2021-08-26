const content = document.querySelector(".content")
content.addEventListener('click', e => {
  const answer = e.target
  if (answer.tagName.toLowerCase() == 'input') {
    const question = e.target.closest('.question')
    const radios = question.querySelectorAll('input')
    const correctAnswer = question.getAttribute('answer')
    if (answer.value == correctAnswer){
      answer.closest('label').style.color = '#04FF57'
    }
    else{
      answer.closest('label').style.color = '#D6040D'
      question.querySelector(`div.q-ans > label:nth-child(${correctAnswer})`).style.color = '#04FF57'
    }
    for (let i =0; i < radios.length; i++)
      radios[i].disabled = true
  }
  if (answer.className.toLowerCase() == 'remove btn'){
    const question = e.target.closest('.question')
    const id = question.id
    const form = question.querySelector('.removeForm')
    form.submit()
  }
})

const quizlet = document.querySelector("body > div.menu-bar > div.logo")
quizlet.addEventListener('click', e => {
  window.location.href = `http://localhost:8080/`
})