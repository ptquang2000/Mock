const loginButton = document.querySelector('button')
const loginForm = document.querySelector('.loginform')
loginButton.addEventListener('click', e => {
  if (loginForm.style.display == '')
    loginForm.style.display = 'block'
  else  
    loginForm.style.display = ''
})
document.addEventListener('click', e =>{
  const formChild = e.target.closest('.loginform')
  if (formChild != null) return
  if (loginForm.style.display == 'block' && e.target != loginButton)
    loginForm.style.display = ''

})