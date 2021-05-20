// let user = {
//     id : '1',
//     name : 'Ramazan',
//     userName : 'tu1anbaevv',
//     email : 'Ramazan@gmail.con',
//     password : '4284254',
//     isAuthorised:false
// };
//
// function authorised() {
//     user.isAuthorised = !user.isAuthorised;
// }
//
// let publication = {
//     id : '1',
//     date : '13.01.21',
//     publicationImage : "1.jpeg",
//     User:user,
//     Comment:comment,
//     likes: "",
//     description: ""
//     // Передал User к user
// };
//
// let comment = {
//     id : '1',
//     publication:publication,
//     message : 'dgsdfhdngx',
//     localDate : '10.08.19',
//     User:user
// };
//
// let addPublication = [];
//
// function addPublication(){
//     addPublication.push(publication)
// }
//
// function changeStateUser() {
//     user.isAuthorised = !user.isAuthorised;
// }
// function changeStatePost(id) {
//
//     this.publication = !publication;
//
//     function deleteLike() {
//         publication.remove(likes);
//     }
//
//     function addLike() {
//         publication.save(likes);
//     }
//
//     publication[id].likes=false;
// }

// 58

function showSplashScreen() {
    document.getElementsByClassName("splashScreen")[0].style.display = "block";
    document.body.classList.add("no-scroll");
}

function hideSplashScreen() {
    document.getElementsByClassName("splashScreen")[0].style.display = "none";
    document.body.classList.remove("no-scroll");
}

function createCommentElement(comment) {
    let createComment = document.createElement('div')
    createComment.innerHTML = "<div>" + "</div>" + "<div>" + comment.message + "</div>" + "<div" + comment.date + "</div>"  + "<div" + comment.username + "</div>";
    return createComment;
}

function createPostElement(post) {
    let createPost = document.createElement("div")
    createPost.innerHTML = "<div>" + '<img class="d-block w-100" src="${imageUrl}" alt="Post image">' + "</div>" + "<div>" + post.description + "</div>" + "<div" + post.date + "</div>"  + "<div" + post.username + "</div>";
    return createPost;
}

function addPost(postElement) {
    document.getElementsByClassName('post-container')[0].append(postElement);
}

//59

let likePhoto = document.querySelectorAll('.like-photo');
const counts = document.getElementById('count');
let countClick = 0;

let clickTime = 0;

for(let photo of likePhoto){
    photo.addEventListener('click', (e) => {
        if(clickTime === 0){
            clickTime = new Date().getTime();
        }
        else{
            if((new Date().getTime() - clickTime) < 800){
                var heart = createLike(e);
                photo.appendChild(heart);
                counts.innerHTML = ++countClick;
                clickTime = 0;
            }
            else{
                clickTime = new Date().getTime();
            }
        }
    });
}

function createLike(e){
    const heart = document.createElement('i');
    heart.classList.add('fas');
    heart.classList.add('fa-heart');

    const x = e.clientX;
    const y = e.clientY;

    const leftOffset = e.target.offsetLeft;
    const topOffset = e.target.offsetTop;

    const xInside = x - leftOffset;
    const yInside = y - topOffset;

    heart.style.top = `${yInside}px`;
    heart.style.left = `${xInside}px`;

    setTimeout(() => heart.remove(), 1000);
    return heart;
}

function addLike() {
    let like = document.getElementsByClassName('fa-heart')[0]
    like.addEventListener('click', function () {
        if (like.classList.contains('fas')) {
            like.classList.remove('fas');
            like.classList.remove('text-danger');
            like.classList.add('far');
        } else {
            like.classList.remove('far');
            like.classList.add('text-danger');
            like.classList.add('fas');
        }
    })
}
function addPhoto() {
    let photo = document.getElementsByClassName("fa-bookmark")[0]
    photo.addEventListener('click',function () {
        if (photo.classList.contains('fas')) {
            photo.classList.remove('fas');
            photo.classList.remove('muted');
            photo.classList.add('far');
        } else {
            photo.classList.remove('far');
            photo.classList.add('muted');
            photo.classList.add('fas');
        }
    })
}
window.addEventListener('load', function () {
    if (restoreUser() === null) {
        showSplashScreen();
    } else {
        hideSplashScreen();
    }
});

function restoreUser() {
    const userAsJSON = localStorage.getItem('user');
    return JSON.parse(userAsJSON);
}
addLike();
addPhoto();