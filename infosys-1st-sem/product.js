let next = document.querySelector('.next')
//Stores a reference to the "next" button element
let prev = document.querySelector('.prev')
//Stores a reference to the "previous" button element.


//functionality added for giving the popup message alerting whenever the add to cart button is clicked
function handleAddToCartClick(productName) {
    alert(productName + " has been added to the cart! Thank You for Shopping.");
}

// Add event listeners to all "Add to Cart" buttons
document.addEventListener('DOMContentLoaded', function () {
    var addToCartButtons = document.querySelectorAll('.item button');

    // Loop through each selected button
    addToCartButtons.forEach(function (button) {
        // Add a click event listener to each button
        button.addEventListener('click', function () {
            // Check if the clicked button is the "See more details" button
            if (!button.classList.contains('see-more-details')) {
                // Get the product name associated with the clicked button
                var productName = this.parentElement.querySelector('.name').innerText.trim();

                // Call the handleAddToCartClick function with the product name as an argument
                handleAddToCartClick(productName);
            }
        });
    });
});
//Adds a click event listener to the "next" button to move items forward.
next.addEventListener('click', function () {
    let items = document.querySelectorAll('.item')
    document.querySelector('.slide').appendChild(items[0])
})
//Adds a click event listener to the "previous" button to move items backward.
prev.addEventListener('click', function () {
    let items = document.querySelectorAll('.item')
    document.querySelector('.slide').prepend(items[items.length - 1])
})

