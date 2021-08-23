const clearCartButton = document.querySelector('a.btn.btn-primary')

let removeProduct = code => {
  let items = JSON.parse(localStorage.getItem("cart"));
  items.forEach((item, idx) => {
    item = JSON.parse(item);
    if (item.code == code){
      item.quantity = --item.quantity;
      existed = true;
      if (item.quantity == 0) 
        items.splice(idx, 1)
      else
        items[idx] = JSON.stringify(item);
    }
  })
  if (items.length == 0)
    localStorage.removeItem("cart");
  else
    localStorage.setItem("cart", JSON.stringify(items));
  let html = ""; 
  html += document.querySelector('.row:first-child').outerHTML;
  html += document.querySelector('.row:last-child').outerHTML;
  document.querySelector('.cart-inner').innerHTML = html;
  addRowsHTML();
  return false;
}

const removeProductFromCart = (idx) => {
	let element = document.querySelector(".row-" + idx);
	let count = parseInt(element.querySelector(".col-2 .data").textContent) - 1;
	if (count == 0)
		element.remove();
	else{
		element.querySelector(".col-2 .data").textContent = count;
		element.querySelector(".col-4 .data").textContent = count * parseInt(element.querySelector(".col-3 .data").textContent);			
	}
	editGrandTotal();
}

const addRowsHTML = () => {
	const cart = JSON.parse(localStorage.getItem("cart"))
	if (cart != null && cart.length >= 0){
		let totalPrice = 0
		let html = ''
		for (let i = 0; i < cart.length; i++){
			const product = cart[i]
			html += `
			<div class="row row-${i}">
				<div class="col-1">${product.name}</div>
				<div class="col-2">
					<span class="title">Quantity</span>
					<span class="data">${cart[i].quantity}</span></div>
				<div class="col-3">
					<span class="title">Unit Price</span>
					<span class="data">${product.price}</span></div>
				<div class="col-4">
					<span class="title">Price</span>
					<span class="data">${product.price * cart[i].quantity}</span></div>
				<div class="col-5">
					<a href=""  onclick="removeItem(${product.id})" class="btn btn-fourth">
					<i class="fa fa-remove" aria-hidden="true"></i>
					Remove
					</a>
				</div>
			</div>
			`
			totalPrice += parseInt(cart[i].quantity) * product.price
		}	
		document.querySelector('.row:first-child').outerHTML += html
		if (totalPrice != 0)
			document.querySelector('.row:last-child').
				querySelector('.col-4').textContent = totalPrice
		else 
			document.querySelector('div.row.total-price div.col-4').textContent = ''
	}
}

const removeItem = (id)=>{
	let cart = JSON.parse(localStorage.getItem('cart'))
  cart.forEach((item, idx) => {
    if (item.id == id){
      item.quantity = --item.quantity
      existed = true
      if (item.quantity == 0) 
        cart.splice(idx, 1)
      else
        cart[idx] = item
    }
  })
  if (cart.length == 0){
    localStorage.setItem('cart', JSON.stringify([]))
		localStorage.setItem('cartTotal', JSON.stringify(0))
	}
  else{
    localStorage.setItem('cart', JSON.stringify(cart))
		localStorage.setItem('cartTotal', JSON.stringify(--parseInt(localStorage.getItem("cartTotal"))))
	}
	console.log(localStorage.getItem('cart'))
	console.log(localStorage.getItem('cartTotal'))
  let html = ""
  html += document.querySelector('.row:first-child').outerHTML
  html += document.querySelector('.row:last-child').outerHTML
  document.querySelector('.cart-inner').innerHTML = html
	addRowsHTML()
	return false
}

document.addEventListener("DOMContentLoaded", ()=>{
	addRowsHTML()

	document.querySelector('.cart-btn').addEventListener('click', (e)=>{
		e.preventDefault()
		if (e.target.className == 'btn btn-primary'){
			let html = ""; 
			html += document.querySelector('.row:first-child').outerHTML;
			html += document.querySelector('.row:last-child').outerHTML;
			document.querySelector('.cart-inner').innerHTML = html;			
			localStorage.setItem('cart', JSON.stringify([]))
			localStorage.setItem('cartTotal', JSON.stringify(0))
			document.querySelector('div.row.total-price div.col-4').textContent = ''
		}
	})
})
