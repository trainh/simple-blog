function validateForm() {
    var email = document.registerForm.txtEmail.value;
    var name = document.registerForm.txtName.value;
    var password = document.registerForm.txtPassword.value;

    if (email === null || email === "") {
        alert("Email isn't valid!!!");
        return false;
    }
    if (name === null || name === "") {
        alert("Name isn't valid!!!");
        return false;
    }
    if (password === null || password === "" || password.length < 6) {
        alert("Password more than 6 characters!!!");
        return false;
    }
}

function validateFormComment() {
    var comment = document.commentForm.txtComment.value;
    if (comment === null || comment === "") {
        alert("Comments can't be left blank!!!");
        return false;
    }
    if (comment > 50) {
        alert("Comment less than 50 words!");
        return false;
    }
}

function validatePost() {
    var tital = document.postForm.txtTital.value.trim();
    var shortDescription = document.postForm.txtShortDescription.value;
    var contentArticle = document.postForm.txtContentArticle.value;
    if (tital === null || tital === "") {
        alert("Tital can't be left blank!!!");
        return false;
    }
    if (test === null || test === "") {
        alert("Tital can't be left blank!!!");
        return false;
    }
    if (tital.length > 100) {
        alert("Tital less than 100 words!");
        return false;
    }
    if (shortDescription === null || shortDescription === "") {
        alert("Short Description can't be left blank!!!");
        return false;
    }
    if (shortDescription.length > 500) {
        alert("Short Description less than 100 words!");
        return false;
    }
    if (contentArticle === null || contentArticle === "") {
        alert("Tital can't be left blank!!!");
        return false;
    }
}
