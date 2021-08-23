const productButton = document.querySelector('.product-btn')
productButton.addEventListener('click',(e)=>{
	if (e.target.className == 'btn btn-secondary'){
		let product = e.target.closest(".product-info")
		let productPrice = parseInt(product.querySelector('span.detail-data.price').textContent.split(" "))
		let productName = product.querySelector('h2').textContent
		let cart = JSON.parse(localStorage.getItem('cart'))
		let cartTotal = JSON.parse(localStorage.getItem('cartTotal'))
		if (cart != null){
			if (cart.length == 0){
				cart.push({
					id: product.id,
					name: productName,
					price: productPrice,
					quantity: 1, 
				})
				localStorage.setItem('cart', JSON.stringify(cart));
				localStorage.setItem('cartTotal', JSON.stringify(++cartTotal))
			}else{
				cart.forEach(item=>{
					if (item.id == product.id) {
						++item.quantity
						++cartTotal
					}
				})
				if (cartTotal == JSON.parse(localStorage.getItem('cartTotal'))){
					cart.push({
						id: product.id,
						name: productName,
						price: productPrice,
						quantity: 1
					})
					++cartTotal
				}
				localStorage.setItem('cartTotal', JSON.stringify(cartTotal))
				localStorage.setItem('cart', JSON.stringify(cart))
			}
		}
		updateCartCounter()

		const notification = document.querySelector('.cart-notification')
		if (!notification.classList.contains('active-noti'))
			notification.classList.toggle('active-noti')
	}
})

const updateCartCounter = () => {
  let cartTotal = parseInt(JSON.parse(localStorage.getItem('cartTotal')))
  if (cartTotal == 0) 
    document.querySelector("span.cartCounter").style.display = 'none'
  else {
    document.querySelector("span.cartCounter").textContent = cartTotal
    document.querySelector("span.cartCounter").style.display = 'block'
  }
}

document.addEventListener('click', (e)=>{
	if (e.target.classList != 'btn btn-secondary')
		if (e.target.classList != 'cart-notification active-noti'){
			const active = document.querySelector('.active-noti')
			if (active != null)
				active.classList.toggle('active-noti')
		}
})

document.addEventListener('DOMContentLoaded', ()=>{
	if (localStorage.getItem('cart') == null){
		localStorage.setItem('cart', JSON.stringify([]))
		localStorage.setItem('cartTotal', JSON.stringify(0))
	}
	updateCartCounter()
})