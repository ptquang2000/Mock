const loginButton = document.querySelector('.login.btn')
if (loginButton != null){
  loginButton.addEventListener('click', e => {
    if (loginForm.style.display == '')
      loginForm.style.display = 'block'
    else  
      loginForm.style.display = ''
  })
}
const logoutButton = document.querySelector('.logout.btn')
if (logoutButton != null){
  logoutButton.addEventListener('click',e=>{
    console.log(loginForm)
    logoutForm.submit()
  })
}
const loginForm = document.querySelector('.loginform')
document.addEventListener('click', e =>{
  const formChild = e.target.closest('.loginform')
  if (formChild != null) return
  if (loginForm.style.display == 'block' && e.target != loginButton)
    loginForm.style.display = ''
})