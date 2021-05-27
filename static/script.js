let user = {
    id : '1',
    name : 'Ramazan',
    userName : 'tu1anbaevv',
    email : 'Ramazan@gmail.con',
    password : '4284254',
    isAuthorised:false
};

function authorised() {
    user.isAuthorised = !user.isAuthorised;
}

let publication = {
    id : '1',
    date : '13.01.21',
    publicationImage : "1.jpeg",
    User:user,
    likes: "",
    description: ""
    // Передал User к user
};

let comment = {
    id : '1',
    publication:publication,
    message : 'dgsdfhdngx',
    localDate : '10.08.19',
    User:user
};

let addPublication = [];

function changeStateUser() {
    user.isAuthorised = !user.isAuthorised;
}
function changeStatePost(id) {

    this.publication = !publication;

    function deleteLike() {
        publication.remove(likes);
    }

    function addLike() {
        publication.save(likes);
    }

    publication[id].likes=false;
}

// 58

function showSplashScreen() {
    document.getElementsByClassName("cards")[0].style.visibility = "hidden"
    document.getElementsByClassName("openSplash")[0].style.visibility =null;
}

function hideSplashScreen() {
    document.getElementsByClassName("openSplash")[0].style.visibility = "hidden"
    document.getElementsByClassName("cards")[0].style.visibility =null;
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

function addFunction(post) {
        let heart = post.getElementsByClassName('like1')[0];
        let bookmark = post.getElementsByClassName('fa-bookmark')[0];
        let img = post.getElementsByClassName('like-heart')[0];
        let btn = post.getElementsByClassName('sing-in')[0];
        let bckSplash = post.getElementsByClassName('back')[0];
        let submit = post.getElementsByClassName('post-form')[0];
        let like = post.getElementsByClassName('like')[0].hidden=true
        let form = post.getElementsByClassName('com-upload-form')[0].getElementsByTagName('form')[0];
        let com = post.getElementsByClassName('fa-comment')[0];
        let data = new FormData(form);
        let id = data.get("postId");

        function loginHandler(e){
            e.preventDefault();
            const form = e.target;
            const data = new FormData(form);
            addPostsFromDB(data)
            console.log("sdf")
            console.log(Object.fromEntries(data))
            // тут можно отправлять данные на сервер
        }

        com.addEventListener('click', function () {
            if(document.getElementById('comFor-' + id).hidden === false) {
                document.getElementById('comFor-' + id).hidden = true;
            } else {
                document.getElementById('comFor-' + id).hidden = false;
            }
        })

        submit.addEventListener('submit', loginHandler);

        bckSplash.addEventListener('click',function () {
              showSplashScreen()
        })
    
        btn.addEventListener('click', function () {
            hideSplashScreen()
            console.log("asdas")
        });

        img.addEventListener('dblclick', function () {
    
         like = document.getElementsByClassName('like')[0].hidden=false;
            setTimeout(() => (
                like = document.getElementsByClassName('like')[0].hidden=true), 500)
            heart.classList.add('text-danger');
            heart.classList.add('fas');
            heart.classList.remove('far');
        })
        ;
    
        bookmark.addEventListener('click', function () {
            if (bookmark.classList.contains('fas')) {
                bookmark.classList.remove('fas');
                bookmark.classList.add('far');
            } else {
                bookmark.classList.remove('far');
                bookmark.classList.add('fas');
            }
        })
    
        heart.addEventListener('click',function () {
            if (heart.classList.contains('fas')) {
                heart.classList.remove('fas');
                heart.classList.remove('text-danger');
                heart.classList.add('far');
            } else {
                heart.classList.remove('far');
                heart.classList.add('text-danger');
                heart.classList.add('fas');
            }
        })
}

function addPostsFromDB(data) {
    let i = data.length;
    for (let j = 0; j < 1; j++) {
        let p = new publication(data[j].id, data[j].user, data[j].publicationImage, data[j].likes, data[j].description);
        addPost(creatPostElement(p));
    }
}

addFunction(document.getElementsByClassName('no-scroll')[0]);