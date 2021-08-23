document.addEventListener("DOMContentLoaded", ()=>{
	const documentClick = () =>{
		let section = document.querySelector("section");
		if (section != null) section.remove();
		document.removeEventListener("click", documentClick);
	}
	document.addEventListener("click", documentClick);
})