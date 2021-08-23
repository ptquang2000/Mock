document.addEventListener("DOMContentLoaded", ()=>{
	const checkAncestor = (e) =>{
		let section = document.querySelector("section");
		if (section != null){
			let ancestor = e.target.closest("section");
			if (ancestor == null){
				document.removeEventListener("click", checkAncestor);
				section.remove();
			}
		} else document.removeEventListener("click", checkAncestor);
	}
	document.addEventListener("click", checkAncestor);
})

const radioInput = document.querySelector('div.radio-input')
radioInput.addEventListener('click', (e)=>{
	e.preventDefault()
	const parent = e.target.closest('.radio-wrapper')
	if (parent != null){
		parent.querySelector('input').checked = true		
	}
})
