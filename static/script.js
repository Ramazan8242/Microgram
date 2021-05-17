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
    Comment:comment,
    likes: ""
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

function addPublication(){
    addPublication.push(publication)
}

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
    document.getElementById("splashScreen").hidden=true;
}

function hideSplashScreen() {
    document.getElementById("splashScreen").hidden=false;
}