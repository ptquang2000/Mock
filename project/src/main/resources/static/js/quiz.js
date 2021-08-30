const content = document.querySelector(".content")
const child_content = content.children[0]
if (child_content != null && child_content.nodeName == 'FORM'){
  content.addEventListener('click', e => {
    const answer = e.target
    if (answer.className.toLowerCase() == 'remove btn'){
      const question = e.target.closest('.question')
      const input = question.querySelector('.remove-input')
      input.click()
    }
    if (answer.className.toLowerCase() == 'update btn'){
      const question = e.target.closest(".question")
      let head = question.querySelector('.q-head')
      head.querySelector(".q-question").setAttribute('value', head.querySelector('.q-test').textContent)

      let label = question.querySelector('.q-ans').querySelectorAll('label')
      for (let i = 0; i < label.length; i ++)
        label[i].querySelector('.ans-input').setAttribute('value',label[i].querySelector('.ans-span').textContent)
      const input = question.querySelector('.update-input')
      input.click()
    }
  })
};
  
if (child_content != null && child_content.nodeName == 'DIV')
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
  })

const quizlet = document.querySelector("body > div.menu-bar > div.logo")
quizlet.addEventListener('click', e => {
  window.location.href = `http://localhost:8080/`
})