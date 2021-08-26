const addQuiz = document.querySelector(".add-btn")
const popUp = document.querySelector("body > div.form-to-add")
addQuiz.addEventListener("click",e=>{
    popUp.classList.toggle("active")
})

document.addEventListener("click",e=>{
    const a = e.target.closest(".form-to-add")
    
    if(a == null && popUp.className == "form-to-add active" && e.target.closest(".add-btn") != addQuiz){
        popUp.classList.remove("active")
    } 
})

