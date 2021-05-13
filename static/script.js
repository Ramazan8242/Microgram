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
