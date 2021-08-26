const content = document.querySelector(".content")
content.addEventListener('click', e => {
  const answer = e.target
    if (answer.tagName.toLowerCase() == 'input') {
      const question = e.target.closest('.question')
      const correctAnswer = question.getAttribute('answer')
      if (answer.value == correctAnswer){
        answer.closest('label').style.color = '#04FF57'
      }
      else{
        answer.closest('label').style.color = '#D6040D'
        question.querySelector(`div.q-ans > label:nth-child(${correctAnswer})`).style.color = '#04FF57'
      }
  }
})